import java.util.*;
import java.text.*;

class Test {
    public static void main(String[] args) {
        Date thisDate = null;
        try {
            thisDate = (new SimpleDateFormat("MM/dd/yyyy")).parse(Calendar.getInstance().getTime().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}