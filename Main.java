import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create Scanner object for user input

        System.out.println("Welcome to the E-Commerce System!");
        System.out.print("Please enter your ID: ");
        int customerId = scanner.nextInt();  // Read customer ID input
        scanner.nextLine();

        System.out.print("Please enter your name: ");
        String customerName = scanner.nextLine();   // Read customer name input

        System.out.print("Please enter your address: ");
        String customerAddress = scanner.nextLine();  // Read customer address input

        Customer customer = new Customer(customerId, customerName, customerAddress);  // Create Customer object

        System.out.print("How many products do you want to add to your cart? ");
        int numProducts = scanner.nextInt();  // Read number of products input
        scanner.nextLine();

        Cart cart = new Cart(customer.getCustomerId(), numProducts);  // Create Cart object
        for (int i = 0; i < numProducts; i++) { // Loop to add products to cart
            System.out.print("Which product would you like to add? (1- Book, 2- T-Shirt, 3- Smartphone): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
        
            switch (choice) {
                case 1:  // Case for adding a book product
                    BookProduct r1 = new BookProduct(10, "OOP", (float) 19.99, "O'Reilly", "X Publications");  // Create BookProduct object
                    cart.addProduct(r1, i);  // Add BookProduct to cart
                    break;
                case 2:
                    ClothingProduct r2 = new ClothingProduct(112, "T-shirt", (float)19.90, "Medium", "Cotton");
                    cart.addProduct(r2, i);
                    break;
                case 3:
                    ElectronicProduct r3= new ElectronicProduct(12, "smartphone",(float)599.9,"Samsung", 1);
                    cart.addProduct(r3, i);
                    break;
                default:
                    System.out.println("Invalid choice. Defaulting to Smartphone.");
                    break;
            }
        }

        float totalPrice = cart.calculatePrice();  // Calculate total price of products in cart
        System.out.println("Total Price: $" + totalPrice);

        System.out.print("Would you like to place the order? (1- Yes, 2- No): ");
        int placeOrderChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (placeOrderChoice == 1) {
            Order order = new Order(customer.getCustomerId(), 1, cart.getProducts(), totalPrice); // Create Order object
            System.out.println("Here's your order's summary:");
            order.printOrderInfo();
        } else {
            System.out.println("Order not placed.");
        }

        scanner.close();  // Close Scanner object
    }
}

