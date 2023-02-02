import java.util.*;

// Class for users details
public class User {
    Scanner scanner = new Scanner(System.in);
    static int sid = 111; // for automatic storing of user id
    String name;
    int id = 0;
    String password, email, phone;
    String address;
    int addtocart[] = new int[1000];
    int addto = 0;
    float amount = 0; // for total amount of the products
    Validation valid = new Validation(); // instantiating validation class
    boolean check;

    // Deleting product from cart
    public void deleteCart(ArrayList<User> users, int id, int c, float prices) {
        for (int k = 0; k < (users.get(c).addto - 1); k++) {
            if ((users.get(c).addtocart[k]) == id) {
                User use = new User();
                use.id = users.get(c).id;
                use.name = users.get(c).name;
                use.password = users.get(c).password;
                use.email = users.get(c).email;
                use.phone = users.get(c).phone;
                use.address = users.get(c).address;
                for (int l = k; l < users.get(c).addto; l++) {
                    use.addtocart[l] = users.get(c).addtocart[++l];
                }
                use.addto = --users.get(c).addto;
                use.amount = users.get(c).amount - prices;
                users.set(c, use);

            } else {
                System.out.println("*********************************");
                System.out.println(" Product ID doesn't exist");
                System.out.println("*********************************");
            }
        }
    }

    // Adding products to cart
    public void addtocart(ArrayList<User> users, int c, int id, float prices) {
        User use = new User();
        use.id = users.get(c).id;
        use.name = users.get(c).name;
        use.password = users.get(c).password;
        use.email = users.get(c).email;
        use.phone = users.get(c).phone;
        use.address = users.get(c).address;
        for (int k = 0; k < users.get(c).addto; k++) {
            use.addtocart[k] = users.get(c).addtocart[k];
        }
        use.addtocart[users.get(c).addto] = id;
        use.addto = ++users.get(c).addto;
        use.amount = users.get(c).amount + prices;
        users.set(c, use);

    }

    // Displaying items in cart;
    public void showCartPage(ArrayList<User> users, int c, ArrayList<Product> products) {
        if (users.get(c).addto <= 0) {

            System.out.println("*********************************");
            System.out.println("    No products added to cart");
            System.out.println("*********************************");
        } else {
            System.out.println("\nProduct_ID  \tProduct_Name  \tProduct_Brand  \tPrice  \t\tDescription"
                    + "\n----------------------------------------------------------------------------------\n");
            for (int k = 0; k < users.get(c).addto; k++) {
                for (int p = 0; p < products.size(); p++) {
                    if (products.get(p).proid == users.get(c).addtocart[k]) {
                        System.out.println(products.get(p).proid
                                + "\t\t"
                                + products.get(p).proname
                                + "\t\t" + products.get(p).probrand + "\t\t" + products.get(p).price + "\t\t"
                                + products.get(p).description);

                    }

                }
            }
            System.out.println(
                    "\n ------------------------------------------------------------------\n                                   Total amount = "
                            + users.get(c).amount);

        }
    }

    // Adding new users
    public void addUsers(ArrayList<User> users) {
        this.id = sid;
        sid += 1;
        this.addto = 0;
        this.amount = 0;
        do {
            System.out.print("Enter you name(username): ");
            this.name = scanner.next();

            check = valid.vaildUsername(this.name, users);
        } while (check);
        do {
            System.out.print("Enter you password: ");
            this.password = scanner.next();
            check = valid.validPassword(this.password);
        } while (check);
        do {
            System.out.print("Enter you email: ");
            this.email = scanner.next();
            check = valid.validEmail(this.email);
        } while (check);
        do {
            System.out.print("Enter you phone: ");
            this.phone = scanner.next();
            check = valid.vaildMobile(this.phone);
        } while (check);
        System.out.print("Enter you address: ");
        scanner.nextLine();
        this.address = scanner.nextLine();

    }

    @Override
    public String toString() {
        return "\n" + id + "\t\t" + name
                + "\t" + email + "\t" + phone + "\t" + address;
    }

}
