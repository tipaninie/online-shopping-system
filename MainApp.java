import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    private static ArrayList<Product> productList = new ArrayList<>();
    private static ShoppingCart cart = new ShoppingCart();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Inisialisasi produk
        initializeProducts();
        
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = getUserChoice();
            
            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    cart.displayCart();
                    break;
                case 4:
                    cart.checkout();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Terima kasih telah berbelanja!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
        
        scanner.close();
    }
    
    private static void initializeProducts() {
        // Menambahkan produk elektronik
        productList.add(new Electronic("E001", "Laptop Asus", 10.25, 5, "Asus", 24));
        productList.add(new Electronic("E002", "Smartphone Samsung", 50.48, 10, "Samsung", 12));
        productList.add(new Electronic("E003", "Headphone Sony", 15.42, 15, "Sony", 6));
        
        // Menambahkan produk pakaian
        productList.add(new Clothing("C001", "Kemeja Formal", 35.27, 20, "L", "Katun"));
        productList.add(new Clothing("C002", "Celana Jeans", 45.19, 15, "32", "Denim"));
        productList.add(new Clothing("C003", "Jaket Hoodie", 27.55, 25, "XL", "Fleece"));
    }
    
    private static void displayMenu() {
        System.out.println("\n===== ONLINE SHOPPING SYSTEM =====");
        System.out.println("1. Lihat Daftar Produk");
        System.out.println("2. Tambah Produk ke Keranjang");
        System.out.println("3. Lihat Keranjang Belanja");
        System.out.println("4. Checkout");
        System.out.println("5. Keluar");
        System.out.println("================================");
        System.out.print("Pilih menu (1-5): ");
    }
    
    private static int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Invalid input
        }
    }
    
    private static void displayProducts() {
        System.out.println("\n===== DAFTAR PRODUK =====");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println("\nProduk #" + (i+1));
            productList.get(i).displayInfo();
            System.out.println("------------------------");
        }
    }
    
    private static void addToCart() {
        displayProducts();
        
        System.out.print("\nMasukkan nomor produk yang ingin dibeli: ");
        int productIndex;
        try {
            productIndex = Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid.");
            return;
        }
        
        if (productIndex < 0 || productIndex >= productList.size()) {
            System.out.println("Nomor produk tidak valid.");
            return;
        }
        
        System.out.print("Masukkan jumlah yang ingin dibeli: ");
        int quantity;
        try {
            quantity = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid.");
            return;
        }
        
        if (quantity <= 0) {
            System.out.println("Jumlah harus lebih dari 0.");
            return;
        }
        
        cart.addItem(productList.get(productIndex), quantity);
    }
}
