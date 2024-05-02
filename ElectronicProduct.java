public class ElectronicProduct extends Product {
    private String brand;
    private int warrantyPeriod;
    //Constructs with parameters.
    public ElectronicProduct(int productId, String name, float price, String brand, int warrantyPeriod) {
        super(productId, name, price);
        this.brand = brand;
        this.warrantyPeriod = Math.abs(warrantyPeriod);
    }

    // Getters and setters

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = Math.abs(warrantyPeriod);
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getBrand() {
        return brand;
    }
    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    // Returns a string representation of the product's name and price.
    public String toString() {
        return    name + "- Price: $" + price ;
    }
    public void Print_Details(){
        System.out.println("name: "+name);
        System.out.println("id: "+productId);
        System.out.println("price: $"+price);
        System.out.println("brand: "+brand);
        System.out.println("warrantyPeriod: "+warrantyPeriod);
    }
}


