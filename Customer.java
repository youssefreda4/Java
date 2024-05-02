public class Customer {
    private int customerId;
    private String name;
    private String address;
    //Constructs with parameters.
    public Customer(int customerId, String name, String address) {
        this.customerId = Math.abs(customerId);
        this.name = name;
        this.address = address;
    }

    // Getters and setters
    
    public void setName(String name) {
        this.name = name;
    }

    public void setCustomerId(int customerId) {
        this.customerId = Math.abs(customerId);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getAddress() {
        return address;
    } 
}