public class Order {
  private int customerId;
  private int orderId;
  private Product[] products;
  private float totalPrice;

  //Constructs with parameters.
  public Order(int customerId, int orderId, Product[] products, float totalPrice) {
      this.customerId = Math.abs(customerId);
      this.orderId = Math.abs(orderId);
      this.products = products;
      this.totalPrice = Math.abs(totalPrice);
  }

  // Getter for customerId
  public int getCustomerId() {
      return customerId;
  }

  // Getter for orderId
  public int getOrderId() {
      return orderId;
  }

  // Getter for products
  public Product[] getProducts() {
      return products;
  }

  // Getter for totalPrice
  public float getTotalPrice() {
      return totalPrice;
  }

  // Method to print order information
  public void printOrderInfo() {
      System.out.println("Order ID: " + orderId);
      System.out.println("Customer ID: " + customerId);
      System.out.println("Products:");
      for (int i = 0; i < products.length; i++) {
        if (products[i] != null) {
            System.out.println("\t" + products[i]);
        }
    }
    System.out.println("Total Price: $" + totalPrice);
    
  }
}
