public class Clothing extends Product {
    // Atribut tambahan
    private String size;
    private String material;
    
    // Constructor
    public Clothing(String id, String name, double price, int stock, String size, String material) {
        super(id, name, price, stock);
        this.size = size;
        this.material = material;
    }
    
    // Getter dan Setter
    public String getSize() {
        return size;
    }
    
    public void setSize(String size) {
        this.size = size;
    }
    
    public String getMaterial() {
        return material;
    }
    
    public void setMaterial(String material) {
        this.material = material;
    }
    
    // Override method displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Ukuran: " + size);
        System.out.println("Bahan: " + material);
    }
}
