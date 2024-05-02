public class Product {
    protected int productId;
    protected String name;
    protected float price;
    //Constructs with parameters.
    public Product(int productId, String name, float price) {
        this.productId = Math.abs(productId);
        this.name = name;
        this.price = Math.abs(price);
    }

    // Getters and setters.

    public void setProductId(int productId) {
        this.productId = Math.abs(productId);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = Math.abs(price);
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getProductId() {
        return productId;
    }
}
