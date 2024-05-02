public class Cart {
    private int customerId;
    private int nProducts;
    private Product[] products;

    //Constructs with parameters.
    public Cart(int customerId, int nProducts) {
        this.customerId = Math.abs(customerId);
        this.nProducts = Math.abs(nProducts);
        this.products = new Product[nProducts];
    }

    // Getters and setters
    
    public void setNProducts(int nProducts) {
        this.nProducts = Math.abs(nProducts);
    }
    public void setCustomerId(int customerId) {
        this.customerId = Math.abs(customerId);
    }

    public int getNProducts() {
        return nProducts;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Product[] getProducts() {
        return products;
    }

    // Method to add a product to the cart
    public void addProduct(Product product, int index) {
        if (index >= 0 && index < nProducts) {
            products[index] = product;
        } else {
            System.out.println("Invalid index to add product to cart.");
        }
    }

    // Method to remove a product from the cart
    public void removeProduct(int index) {
        if (index >= 0 && index < nProducts) {
            products[index] = null;
        } else {
            System.out.println("Invalid index to remove product from cart.");
        }
    }

    // Method to calculate the total price of products in the cart
    public float calculatePrice() {
        float totalPrice = 0;
        for (Product product : products) {
            if (product != null) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }
    

    // Method to place the order
    public void placeOrder() {
        System.out.println("Order placed successfully for Customer ID: " + customerId);
    }
}

