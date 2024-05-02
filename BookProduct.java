public class BookProduct extends Product {
    private String author;
    private String publisher;
    //Constructs with parameters.
    public BookProduct(int productId, String name, float price, String author, String publisher) {
        super(productId, name, price);
        this.author = author;
        this.publisher = publisher;
    }

    // Getters and setters
   
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    // Returns a string representation of the product's name and price.
    public String toString() {
        return   name + "- Price: $" + price ;
    }

    // Prints the details of the product
    public  void Print_Details(){
        System.out.println("name: "+name);
        System.out.println("id: "+productId);
        System.out.println("price: $"+price);
        System.out.println("author: "+author);
        System.out.println("publisher: "+publisher);
    }

}