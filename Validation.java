
import java.util.ArrayList;
import java.util.regex.Pattern;

// Used for validation
public class Validation {
    // validating email
    boolean validEmail(String EmailID) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

        if (Pattern.matches(regex, EmailID)) {
            return false;
        } else {
            System.out.println("worng email-ID");
            return true;
        }

    }

    // Validating UPI
    boolean vaildUPI(int upi) {
        if ((upi > 999) && (upi < 10000))
            return false;
        else {
            System.out.println("Enter valid UPI Number");
            return true;
        }
    }

    // valid CVV
    boolean validCVV(int cvv) {
        if ((cvv > 99) && (cvv < 1000))
            return false;
        else {
            System.out.println("Enter valid CVV");
            return true;
        }
    }

    // valid Debit card number
    boolean validCardNumber(String cardno) {
        if ((cardno.length() >= 13) && (cardno.length() <= 19)) {
            return false;
        } else {
            System.out.println("Invalid CARD NUMBER (13-19 numbers)");
            return true;
        }

    }

    // validating password
    public boolean validPassword(String password) {
        if ((password.length() >= 6)) {
            return false;
        } else {
            System.out.println("Invalid password (It must contain 6 Charaters)");
            return true;
        }
    }

    // validating mobile number
    public boolean vaildMobile(String mobileno) {
        if (mobileno.length() == 10 && (mobileno.startsWith("9") || mobileno.startsWith("8")
                || mobileno.startsWith("7") || mobileno.startsWith("6"))) {
            return false;
        } else {
            System.out.println("Invalid Mobile No");
            return true;
        }
    }

    // validating the Duplicate entries of product id
    public boolean validProducts(ArrayList<Product> products, int id) {
        int flag = 0;
        for (int k = 0; k < products.size(); k++) {
            if (id == products.get(k).proid) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            System.out.println("Product ID already exists");
            return true;
        } else {
            return false;
        }
    }

    // validating product name
    public boolean vaildUsername(String adminUserName) {

        String strPattern = "^[a-zA-Z][a-zA-Z_]{6,19}$";
        if (adminUserName.matches(strPattern)) {
            return false;
        } else {
            System.out.println("Invalid name (only alphabets and underscore)(7 characters max)");
            return true;

        }
    }

    public boolean validProductName(String proname) {
        if (proname.isEmpty()) {
            System.out.println("Invalid Product Name");
            return true;
        } else
            return false;
    }

    public boolean validExpiryDate(String expire) {
        String regrex = "^[0-90-9/0-90-9]{5}$";
        if (expire.matches(regrex)) {
            return false;
        } else
            return true;
    }

    // validating duplicate username
    public boolean vaildUsername(String adminusername, ArrayList<User> users) {
        int flag = 0;
        for (int k = 0; k < users.size(); k++) {
            if ((adminusername.equals(users.get(k).name))) {
                flag = 1;
                break;
            }
        }
        if ((adminusername.isEmpty()) || (flag == 1)) {
            System.out.println("User already exists");
            return true;
        } else {
            boolean checkk = vaildUsername(adminusername);
            return checkk;
        }

    }

    // vaidating price
    public boolean vaildPrice(float price) {
        if (price <= 0) {
            System.out.println("Invalid price");
            return true;
        } else {
            return false;
        }

    }
}
