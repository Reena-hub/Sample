import java.util.*;

//Class for product details
public class Product {
    int proid;
    String proname, probrand;
    float price;
    String description;
    boolean check;
    Scanner scanner = new Scanner(System.in);

    // Adding products to list
    public void addProducts(ArrayList<Product> products) {
        Validation valid = new Validation();
        do {
            System.out.print("Enter product ID:");
            this.proid = scanner.nextInt();
            check = valid.validProducts(products, this.proid);
        } while (check);

        do {
            System.out.print("Enter product name:");
            this.proname = scanner.next();
            check = valid.validProductName(this.proname);
        } while (check);

        System.out.print("Enter product Brand:");
        this.probrand = scanner.next();
        do {
            System.out.print("Enter product price:");
            this.price = scanner.nextFloat();
            check = valid.vaildPrice(this.price);
        } while (check);
        System.out.print("Enter product Description:");
        scanner.nextLine();
        this.description = scanner.nextLine();
    }

    @Override
    public String toString() {
        return "\n" + proid
                + "\t\t"
                + proname
                + "\t\t" + probrand + "\t\t" + price + "\t\t" + description;
    }
}
