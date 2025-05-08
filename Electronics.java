public class Electronic extends Product {
    // Atribut tambahan
    private String brand;
    private int warrantyPeriod; // dalam bulan
    
    // Constructor
    public Electronic(String id, String name, double price, int stock, String brand, int warrantyPeriod) {
        super(id, name, price, stock);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }
    
    // Getter dan Setter
    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }
    
    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }
    
    // Override method displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Brand: " + brand);
        System.out.println("Masa Garansi: " + warrantyPeriod + " bulan");
    }
}
