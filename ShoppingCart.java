import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> items;
    private ArrayList<Integer> quantities;
    
    public ShoppingCart() {
        items = new ArrayList<>();
        quantities = new ArrayList<>();
    }
    
    public void addItem(Product product, int quantity) {
        if (product.getStock() >= quantity) {
            items.add(product);
            quantities.add(quantity);
            System.out.println(quantity + " " + product.getName() + " ditambahkan ke keranjang.");
        } else {
            System.out.println("Maaf, stok " + product.getName() + " tidak mencukupi.");
        }
    }
    
    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getPrice() * quantities.get(i);
        }
        return total;
    }
    
    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Keranjang belanja kosong.");
            return;
        }
        
        System.out.println("\n===== ISI KERANJANG BELANJA =====");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i+1) + ". " + items.get(i).getName() + 
                              " - " + quantities.get(i) + " x EURO " + 
                              items.get(i).getPrice() + " = EURO " + 
                              (items.get(i).getPrice() * quantities.get(i)));
        }
        System.out.println("Total: EURO " + calculateTotal());
        System.out.println("================================");
    }
    
    public void checkout() {
        if (items.isEmpty()) {
            System.out.println("Keranjang belanja kosong. Tidak dapat checkout.");
            return;
        }
        
        boolean allSuccess = true;
        
        // Coba beli semua barang di keranjang
        for (int i = 0; i < items.size(); i++) {
            if (!items.get(i).buy(quantities.get(i))) {
                allSuccess = false;
                break;
            }
        }
        
        if (allSuccess) {
            System.out.println("Checkout berhasil! Total pembayaran: EURO " + calculateTotal());
            // Kosongkan keranjang setelah checkout berhasil
            items.clear();
            quantities.clear();
        } else {
            System.out.println("Checkout gagal. Silakan periksa kembali stok produk.");
        }
    }
}
