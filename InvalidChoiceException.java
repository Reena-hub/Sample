
import java.lang.Exception;

// Exception handling
public class InvalidChoiceException extends Exception {
    String msg;

    // Constructor for instatiating the message
    InvalidChoiceException() {
        msg = "Invalid Choice";
    }

    String getMsg() {
        return msg;
    }
}