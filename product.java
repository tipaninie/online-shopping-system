public class Product {
    // Atribut
    protected String id;
    protected String name;
    protected double price;
    protected int stock;
    
    // Constructor
    public Product(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    
    // Getter dan Setter
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getStock() {
        return stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    // Method untuk menampilkan info produk
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Nama: " + name);
        System.out.println("Harga: EUR " + price);
        System.out.println("Stok: " + stock);
    }
    
    // Method untuk mengurangi stok ketika dibeli
    public boolean buy(int quantity) {
        if (stock >= quantity) {
            stock -= quantity;
            System.out.println(quantity + " " + name + " berhasil dibeli.");
            return true;
        } else {
            System.out.println("Maaf, stok tidak mencukupi.");
            return false;
        }
    }
}
