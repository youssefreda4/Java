import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class LoginGUI extends JFrame {

    private String name;
    private String id;
    private String address;

    public LoginGUI() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create components
        JLabel welcomeLabel = new JLabel("Welcome to the E-commerce System ");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setForeground(Color.WHITE);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.WHITE);
        JTextField nameField = new JTextField(20);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setForeground(Color.WHITE);
        JTextField idField = new JTextField(20);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setForeground(Color.WHITE);
        JTextField addressField = new JTextField(20);

        JButton okButton = new JButton("OK");
        okButton.setBackground(Color.BLACK);
        okButton.setForeground(Color.WHITE);
        okButton.setPreferredSize(new Dimension(100, 30));


        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(welcomeLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(nameLabel, gbc);

        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(idLabel, gbc);

        gbc.gridx = 1;
        panel.add(idField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(addressLabel, gbc);

        gbc.gridx = 1;
        panel.add(addressField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(okButton, gbc);


        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String numProductsStr = JOptionPane.showInputDialog(null, "How many products do you want to add to your cart?", "Product Quantity", JOptionPane.QUESTION_MESSAGE);
                if (numProductsStr != null) {
                    try {
                        int numProducts = Integer.parseInt(numProductsStr);
                        StringBuilder selectedProducts = new StringBuilder();
                        float totalPrice = 0;
                        Random rand = new Random();
                        int orderID = rand.nextInt(1000);
                        for (int i = 0; i < numProducts; i++) {
                            String[] options = {"Book", "T-shirt", "Smartphone"};
                            int choice = JOptionPane.showOptionDialog(null, "Which product would you like to add?", "Product Selection", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                            if (choice != JOptionPane.CLOSED_OPTION) {
                                String productName = options[choice];
                                float price = getProductPrice(productName);
                                totalPrice += price;
                                selectedProducts.append(productName).append(" - $").append(price).append("\n");
                            }
                        }
                        // Update user data
                        name = nameField.getText();
                        id = idField.getText();
                        address = addressField.getText();

                        int option = JOptionPane.showConfirmDialog(null, "Total Price: $" + totalPrice +  JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Here's Your Order Summary:\n" +
                                    "Order ID: " + orderID + "\n" +
                                    "Customer ID: " + id + "\n" +
                                    "Products:\n" +
                                    selectedProducts.toString() +
                                    "Total Price: $" + totalPrice, "Order Summary", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Order not placed.", "Order Status", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number for the quantity.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });


        add(panel);

        setVisible(true);
    }

    private float getProductPrice(String productName) {
        switch (productName) {
            case "Book":
                return 19.99f;
            case "T-shirt":
                return 9.99f;
            case "Smartphone":
                return 599.99f;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginGUI::new);
    }
}






















/*import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class LoginGUI extends JFrame {

    public LoginGUI() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the window

        // Create components
        JLabel welcomeLabel = new JLabel("Welcome to the E-commerce ");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setForeground(Color.WHITE); // Set text color to white

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.WHITE); // Set text color to white
        JTextField nameField = new JTextField(20);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setForeground(Color.WHITE); // Set text color to white
        JTextField idField = new JTextField(20);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setForeground(Color.WHITE); // Set text color to white
        JTextField addressField = new JTextField(20);

        JButton okButton = new JButton("OK");
        okButton.setBackground(Color.BLACK); // Set button background color to black
        okButton.setForeground(Color.WHITE); // Set button text color to white
        okButton.setPreferredSize(new Dimension(100, 30)); // Set button size

        // Set layout for the panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK); // Set panel background color to black
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(welcomeLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(nameLabel, gbc);

        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(idLabel, gbc);

        gbc.gridx = 1;
        panel.add(idField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(addressLabel, gbc);

        gbc.gridx = 1;
        panel.add(addressField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(okButton, gbc);

        // Add action listener to the OK button
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action when OK button is clicked
                String numProductsStr = JOptionPane.showInputDialog(null, "How many products do you want to add to your cart?", "Product Quantity", JOptionPane.QUESTION_MESSAGE);
                if (numProductsStr != null) {
                    try {
                        int numProducts = Integer.parseInt(numProductsStr);
                        StringBuilder selectedProducts = new StringBuilder();
                        float totalPrice = 0;
                        for (int i = 0; i < numProducts; i++) {
                            String[] options = {"Book", "T-shirt", "Smartphone"};
                            int choice = JOptionPane.showOptionDialog(null, "Which product would you like to add?", "Product Selection", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                            if (choice != JOptionPane.CLOSED_OPTION) {
                                String productName = options[choice];
                                float price = getProductPrice(productName);
                                totalPrice += price;
                                selectedProducts.append(productName).append(" - $").append(price).append("\n");
                            }
                        }
                        int option = JOptionPane.showConfirmDialog(null, "Total Price: $" + totalPrice + JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Here's Your Order Summary:\n" + selectedProducts.toString(), "Order Summary", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Order not placed.", "Order Status", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number for the quantity.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Add panel to frame
        add(panel);

        setVisible(true);
    }

    private float getProductPrice(String productName) {
        // Return the price based on the product name
        switch (productName) {
            case "Book":
                return 19.99f;
            case "T-shirt":
                return 9.99f;
            case "Smartphone":
                return 599.99f;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginGUI::new);
    }
}*/