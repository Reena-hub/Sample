
import java.util.*;
import java.io.Console;

//Login and Menu operations
public class Login implements ILogin {
    Scanner scanner = new Scanner(System.in);
    ArrayList<User> users = new ArrayList<User>(); // Object Instatiation
    ArrayList<Product> products = new ArrayList<>(); // Object Instatiation
    String username, password, cardno, expiry_date;
    int choice, id, flag, upi, cvv;

    Validation valid = new Validation();

    // For Viewers
    public void showUserLogin() {
        System.out.println("\n-------------------------------------------------------------");
        System.out.println("               WELCOME TO G R SHOPPING SITE  ");
        System.out.println("-------------------------------------------------------------");
        System.out.println(" Options : ");
        System.out.println("1. List Product Details");
        System.out.println("2. Login");
        System.out.println("3. Sign In");
        System.out.println("4. Exit ");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        try {
            if ((choice <= 0) || (choice > 4))
                throw new InvalidChoiceException();
        } catch (InvalidChoiceException exception) {
            System.out.println("\n*********************************");
            System.out.println(" Exceptions : " + exception.getMsg());
            System.out.println("*********************************");
            showUserLogin();
        }
        switch (choice) {
            case 1:
                if (products.size() == 0) {

                    System.out.println("\n*********************************");
                    System.out.println("       No Products available");
                    System.out.println("*********************************");
                } else {
                    for (Product pro : products) {
                        System.out.println(pro);
                    }
                }
                showUserLogin();
                break;
            case 2:
                showLogin();
                break;
            case 3:
                User user = new User();
                user.addUsers(users);
                users.add(user);

                System.out.println("\n********************************");
                System.out.println("     SuccessFully Registered");
                System.out.println("********************************");
                showLogin();
                break;
            case 4:
                System.out.println("\n********************************");
                System.out.println("      Thanks for visiting");
                System.out.println("********************************");
                break;
        }

    }

    // Login purpose
    public void showLogin() {
        int j;
        Console console = System.console();
        System.out.println("\n***************************************");
        System.out.println("               Login Page              ");
        System.out.println("***************************************");
        do {
            System.out.print("\nEnter username:");
            this.username = scanner.next();
        } while (valid.vaildUsername(this.username));

        char[] pw = console.readPassword("Enter Password: ");
        for (int k = 0; k < pw.length; k++) {
            System.out.print("*");
        }
        String password = String.valueOf(pw, 0, pw.length);
        if ((username.equals("admin__")) && (password.equals("admin@123"))) {
            System.out.println("\n***************************************");
            System.out.println("          Login Successfull            ");
            System.out.println("***************************************");
            showAdminMenu();

        } else {
            flag = 0;
            for (j = 0; j < users.size(); j++) {
                if ((username.equals(users.get(j).name)) && (password.equals(users.get(j).password))) {
                    System.out.println("\n***************************************");
                    System.out.println("          Login Successfull            ");
                    System.out.println("***************************************");
                    flag = 1;
                    showUserMenu();
                }
            }
            if (flag == 0) {
                System.out.println("\n*********************************");
                System.out.println("   Username/ Password is wrong");
                System.out.println("*********************************");
                int k;
                System.out.print("\nAre you a new User? \n Press 1 for new user \n Press 2 for login\n");
                k = scanner.nextInt();
                try {
                    if ((k <= 0) || (k >= 3))
                        throw new InvalidChoiceException();
                } catch (InvalidChoiceException exception) {
                    System.out.println("\n*********************************");
                    System.out.println(" Exceptions : " + exception.getMsg());
                    System.out.println("*********************************");
                    showLogin();
                }
                if (k == 1) {
                    User user = new User();
                    user.addUsers(users);
                    users.add(user);

                    System.out.println("\n********************************");
                    System.out.println("     SuccessFully Registered");
                    System.out.println("********************************");

                }
                showLogin();
            }
        }

    }

    // users menu
    public void showUserMenu() {
        int c, inc = 0;
        String name;
        User use = new User();
        System.out.println("\n-------------------------------------------------------------");
        System.out.println("               WELCOME TO G R SHOPPING SITE  ");
        System.out.println("-------------------------------------------------------------");
        System.out.println(" Options : ");
        System.out.println("1. List Product Details");
        System.out.println("2. Search particular products");
        System.out.println("3. Add Products to cart");
        System.out.println("4. Delete Products from cart ");
        System.out.println("5. List Add to cart products");
        System.out.println("6. Payment for add to cart page");
        System.out.println("7. Go to Main menu");
        System.out.println("8. Logout");
        System.out.print("\nEnter your option :  ");
        choice = scanner.nextInt();
        try {
            if ((choice <= 0) || (choice > 8))
                throw new InvalidChoiceException();
        } catch (InvalidChoiceException exception) {
            System.out.println("\n*********************************");
            System.out.println(" Exceptions : " + exception.getMsg());
            System.out.println("*********************************");
            showUserMenu();
        }
        switch (choice) {
            case 1:
                if (products.size() == 0) {
                    System.out.println("\n*********************************");
                    System.out.println("       No Products available");
                    System.out.println("*********************************");
                } else {
                    inc = 1;
                    System.out.println("\nProduct_ID  \tProduct_Name  \tProduct_Brand  \tPrice  \t\tDescription"
                            + "\n----------------------------------------------------------------------------------");

                    for (Product pro : products) {
                        System.out.println(pro);
                        inc++;
                    }
                }

                showUserMenu();
                break;
            case 2:
                System.out.println("\nOptions: ");
                System.out.println("1. Product Name");
                System.out.println("2. Price");
                System.out.println("3. Brand");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                try {
                    if ((choice <= 0) || (choice >= 4))
                        throw new InvalidChoiceException();
                } catch (InvalidChoiceException exception) {
                    System.out.println("\n*********************************");
                    System.out.println(" Exceptions : " + exception.getMsg());
                    System.out.println("*********************************");
                    showUserMenu();
                }
                switch (choice) {
                    case 1:
                        System.out.print("\nEnter the product name: ");
                        name = scanner.next();
                        flag = 0;
                        inc = 1;
                        for (c = 0; c < products.size(); c++) {
                            if (name.equalsIgnoreCase(products.get(c).proname)) {
                                flag = 1;
                                inc++;
                            }
                        }
                        if (flag == 0) {

                            System.out.println("\n*********************************");
                            System.out.println("      No Products available");
                            System.out.println("*********************************");
                        } else {
                            System.out.println("\nProduct_ID  \tProduct_Name  \tProduct_Brand  \tPrice  \t\tDescription"
                                    + "\n----------------------------------------------------------------------------------\n");
                            for (c = 0; c < products.size(); c++) {
                                if (name.equalsIgnoreCase(products.get(c).proname)) {
                                    System.out.println(products.get(c).proid
                                            + "\t\t"
                                            + products.get(c).proname
                                            + "\t\t" + products.get(c).probrand + "\t\t" + products.get(c).price
                                            + "\t\t"
                                            + products.get(c).description);

                                }
                            }
                        }
                        break;
                    case 2:
                        System.out.print("\nEnter the Minimum product price: ");
                        float price1 = scanner.nextFloat();
                        System.out.print("Enter the maximum product price: ");
                        float price2 = scanner.nextFloat();
                        inc = 1;
                        flag = 0;
                        for (c = 0; c < products.size(); c++) {
                            if ((products.get(c).price <= price2) && (products.get(c).price >= price1)) {
                                inc++;
                                flag = 1;
                            }
                        }
                        if (flag == 0) {

                            System.out.println("\n*********************************");
                            System.out.println("       No Products available");
                            System.out.println("*********************************");
                        } else {
                            System.out.println("\nProduct_ID  \tProduct_Name  \tProduct_Brand  \tPrice  \t\tDescription"
                                    + "\n----------------------------------------------------------------------------------\n");
                            for (c = 0; c < products.size(); c++) {
                                if ((products.get(c).price <= price2) && (products.get(c).price >= price1)) {
                                    System.out.println(products.get(c).proid
                                            + "\t\t"
                                            + products.get(c).proname
                                            + "\t\t" + products.get(c).probrand + "\t\t" + products.get(c).price
                                            + "\t\t"
                                            + products.get(c).description);

                                }
                            }
                        }
                        break;
                    case 3:
                        System.out.print("\nEnter the product brand: ");
                        name = scanner.next();
                        inc = 1;
                        flag = 0;
                        for (c = 0; c < products.size(); c++) {
                            if (name.equals(products.get(c).probrand)) {
                                flag = 1;
                                inc++;
                            }
                        }
                        if (flag == 0) {

                            System.out.println("\n*********************************");
                            System.out.println("       No Products available");
                            System.out.println("*********************************");
                        } else {
                            System.out.println("\nProduct_ID  \tProduct_Name  \tProduct_Brand  \tPrice  \t\tDescription"
                                    + "\n----------------------------------------------------------------------------------\n");
                            for (c = 0; c < products.size(); c++) {
                                if (name.equals(products.get(c).probrand)) {
                                    System.out.println(products.get(c).proid
                                            + "\t\t"
                                            + products.get(c).proname
                                            + "\t\t" + products.get(c).probrand + "\t\t" + products.get(c).price
                                            + "\t\t"
                                            + products.get(c).description);

                                }
                            }
                        }
                        break;
                }
                showUserMenu();
                break;
            case 3:
                System.out.print("\nEnter product ID that to be added to cart: ");
                id = scanner.nextInt();
                flag = 0;
                float prices = 0;
                for (c = 0; c < products.size(); c++) {
                    if (id == products.get(c).proid) {
                        prices = products.get(c).price;
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1) {
                    for (c = 0; c < users.size(); c++) {
                        if (username.equals(users.get(c).name)) {

                            use.addtocart(users, c, id, prices);
                            System.out.println("\n*********************************");
                            System.out.println("     Product added to cart");
                            System.out.println("*********************************");
                            break;
                        }

                    }

                } else {

                    System.out.println("\n*********************************");
                    System.out.println("     Product ID doesn't exist");
                    System.out.println("*********************************");
                }
                showUserMenu();
                break;
            case 4:
                System.out.print("\nEnter product id to be deleted: ");
                id = scanner.nextInt();
                prices = 0;
                int p;
                for (p = 0; p < users.size(); p++) {
                    if (username.equals(users.get(p).name)) {
                        break;
                    }
                }
                flag = 0;
                for (c = 0; c < products.size(); c++) {
                    if (id == products.get(c).proid) {
                        prices = products.get(c).price;
                        break;
                    }
                }
                for (int k = 0; k < users.get(p).addto; k++) {
                    if ((users.get(p).addtocart[k]) == id) {
                        flag = 1;
                        use.id = users.get(p).id;
                        use.name = users.get(p).name;
                        use.password = users.get(p).password;
                        use.email = users.get(p).email;
                        use.phone = users.get(p).phone;
                        use.address = users.get(p).address;
                        int l;
                        for (l = 0; l < k; l++) {
                            use.addtocart[l] = users.get(p).addtocart[l];
                        }
                        for (l = k; l < users.get(p).addto; l++) {
                            use.addtocart[l] = users.get(p).addtocart[++l];
                        }
                        use.addto = --users.get(p).addto;
                        use.amount = users.get(p).amount - prices;
                        users.set(c, use);
                        break;
                    }
                }
                if (flag == 1) {
                    System.out.println("\n*********************************");
                    System.out.println("        Product Deleted");
                    System.out.println("*********************************");

                } else {
                    System.out.println("\n*********************************");
                    System.out.println("     Product ID doesn't exist");
                    System.out.println("*********************************");
                }
                showUserMenu();
                break;
            case 5:
                System.out.println("\n*********************************");
                System.out.println("           Cart Page");
                System.out.println("*********************************");
                for (c = 0; c < users.size(); c++) {
                    if (username.equals(users.get(c).name)) {

                        use.showCartPage(users, c, products);
                        break;
                    }
                }
                showUserMenu();
                break;
            case 6:
                System.out.println("\n*********************************");
                System.out.println("           Payment Page");
                System.out.println("*********************************");
                for (c = 0; c < users.size(); c++) {
                    if (username.equals(users.get(c).name)) {
                        if (users.get(c).addto == 0) {
                            System.out.println("**************************");
                            System.out.println("No Products added to cart");
                            System.out.println("**************************");

                        } else {
                            System.out.println(" Total amount: " + users.get(c).amount);
                            System.out.println("\nMode of Payment: ");
                            System.out.println("1. Phone Pay");
                            System.out.println("2. GPay");
                            System.out.println("3. Cash on Delivery");
                            System.out.println("4. Card");
                            System.out.print("Enter your choice:");
                            c = scanner.nextInt();
                            try {
                                if ((c <= 0) || (c >= 5))
                                    throw new InvalidChoiceException();
                            } catch (InvalidChoiceException exception) {
                                System.out.println("\n*********************************");
                                System.out.println(" Exceptions : " + exception.getMsg());
                                System.out.println("*********************************");
                                showUserMenu();
                            }
                            switch (c) {
                                case 1:
                                    do {
                                        System.out.print(" Enter UPI Number: ");
                                        upi = scanner.nextInt();
                                    } while (valid.vaildUPI(upi));

                                    System.out.println("\n*********************************");
                                    System.out.println("       Payment Successfull");
                                    System.out.println("*********************************");
                                    break;
                                case 2:
                                    do {
                                        System.out.print(" Enter UPI Number: ");
                                        upi = scanner.nextInt();
                                    } while (valid.vaildUPI(upi));

                                    System.out.println("\n*********************************");
                                    System.out.println("       Payment Successfull");
                                    System.out.println("*********************************");
                                    break;
                                case 3:
                                    System.out.println("\n*********************************");
                                    System.out.println("       Cash on delivery");
                                    System.out.println("*********************************");
                                    break;
                                case 4:
                                    do {
                                        System.out.print(" Enter card number: ");
                                        cardno = scanner.next();

                                    } while (valid.validCardNumber(cardno));
                                    do {
                                        System.out.print(" Enter Expiry date: ");
                                        expiry_date = scanner.next();
                                    } while (valid.validExpiryDate(expiry_date));

                                    do {
                                        System.out.print(" Enter CVV: ");
                                        cvv = scanner.nextInt();
                                    } while (valid.validCVV(cvv));

                                    System.out.println("\n*********************************");
                                    System.out.println("       Payment Successfull");
                                    System.out.println("*********************************");
                                    break;
                            }

                        }
                    }

                }
                showUserMenu();

                break;
            case 7:
                System.out.println("\n********************************");
                System.out.println("      Thanks for visiting");
                System.out.println("********************************");
                showLogin();
                break;
            case 8:
                System.out.println("\n********************************");
                System.out.println("      Thanks for visiting");
                System.out.println("********************************");
                break;
            default:

                System.out.println("\n*********************************");
                System.out.println(" Please enter valid option (1-6)");
                System.out.println("*********************************");
        }
    }

    // admin menu
    public void showAdminMenu() {
        int c, j;
        System.out.println("\n-------------------------------------------------------------");
        System.out.println("               WELCOME TO G R SHOPPING SITE  ");
        System.out.println("-------------------------------------------------------------");
        System.out.println("   Options :  ");
        System.out.println("1. Add Products ");
        System.out.println("2. Delete Products ");
        System.out.println("3. List Customer Details ");
        System.out.println("4. List Product Details ");
        System.out.println("5. Add to Cart page");
        System.out.println("6. Go to Main page");
        System.out.println("7. Logout");
        System.out.print("\nEnter your option :  ");
        choice = scanner.nextInt();
        try {
            if ((choice <= 0) || (choice >= 8))
                throw new InvalidChoiceException();
        } catch (InvalidChoiceException exception) {
            System.out.println("\n*********************************");
            System.out.println(" Exceptions : " + exception.getMsg());
            System.out.println("*********************************");
            showAdminMenu();
        }
        switch (choice) {
            case 1:
                Product produ = new Product();
                produ.addProducts(products);
                products.add(produ);
                System.out.println("\n*********************************");
                System.out.println("           Product Added");
                System.out.println("*********************************");
                showAdminMenu();
                break;
            case 2:
                if (products.size() == 0) {
                    System.out.println("\n*********************************");
                    System.out.println("     No Products available");
                    System.out.println("*********************************");
                } else {
                    System.out.print("\nEnter the product ID to be deleted: ");
                    id = scanner.nextInt();
                    flag = 0;
                    for (c = 0; c < products.size(); c++) {
                        if (id == (products.get(c).proid)) {
                            products.remove(c);
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 1) {

                        System.out.println("\n*********************************");
                        System.out.println("         Product Deleted");
                        System.out.println("*********************************");
                    } else {

                        System.out.println("\n*********************************");
                        System.out.println("    Product ID doesn't exist");
                        System.out.println("*********************************");
                    }
                }
                showAdminMenu();
                break;
            case 3:
                if (users.size() == 0) {
                    System.out.println("\n*********************************");
                    System.out.println("     No Customers available");
                    System.out.println("*********************************");

                } else {
                    j = 1;
                    System.out.println("\nUser_ID  \tName  \t\t EMail  \tPhone  \t\tAddress"
                            + "\n-----------------------------------------------------------------");
                    for (User use : users) {

                        System.out.println(use);
                        j++;
                    }
                }

                showAdminMenu();
                break;
            case 4:
                if (products.size() == 0) {
                    System.out.println("\n*********************************");
                    System.out.println("       No Products available");
                    System.out.println("*********************************");
                } else {
                    j = 1;
                    System.out.println("\nProduct_ID  \tProduct_Name  \tProduct_Brand  \tPrice  \t\tDescription"
                            + "\n----------------------------------------------------------------------------------");

                    for (Product pro : products) {
                        System.out.println(pro);
                        j++;
                    }
                }
                showAdminMenu();

                break;
            case 5:
                j = 1;
                User use = new User();
                flag = 0;
                for (c = 0; c < users.size(); c++) {
                    if (users.get(c).addto > 0) {
                        System.out.println("\n*********************************");
                        System.out.println("        Customer " + j);
                        System.out.println("        Customer ID: " + users.get(c).id);
                        System.out.println("        Customer Name: " + users.get(c).name);
                        System.out.println("*********************************");
                        use.showCartPage(users, c, products);
                        j++;
                        flag = 1;
                    }

                }
                if (flag != 1) {

                    System.out.println("\n*********************************");
                    System.out.println("           Cart is empty  ");
                    System.out.println("*********************************");
                }
                showAdminMenu();
                break;
            case 6:
                System.out.println("\n********************************");
                System.out.println("      Thanks for visiting");
                System.out.println("********************************");
                showLogin();
                break;
            case 7:
                System.out.println("\n********************************");
                System.out.println("      Thanks for visiting");
                System.out.println("********************************");
                break;
            default:

                System.out.println("\n*********************************");
                System.out.println(" Please enter valid option (1-6)");
                System.out.println("*********************************");
        }

    }
}
