public class ClothingProduct extends Product {
    private String size;
    private String fabric;
    //Constructs with parameters.
    public ClothingProduct(int productId, String name, float price, String size, String fabric) {
        super(productId, name, price);
        this.size = size;
        this.fabric = fabric;
    }

    // Getters and setters
    
    public void setSize(String size) {
        this.size = size;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public String getSize() {
        return size;
    }

    public String getFabric() {
        return fabric;
    }
    // Returns a string representation of the product's name and price.
    public String toString() {
        return  name + "- Price: $" + price ;
    }
    public void Print_Details(){
        System.out.println("name: "+name);
        System.out.println("id: "+productId);
        System.out.println("price: $"+price);
        System.out.println("size: "+size);
        System.out.println("fabric: "+fabric);
    }

}
