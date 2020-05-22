import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class TestCombo {
   public static void main(String[] args) {
      JComboBox<Country> countryBox = new JComboBox<Country>(Country.values());
      JOptionPane.showMessageDialog(null, new JScrollPane(countryBox));
   }
}

enum Country {

   AF("af", "Afghanistan"),

   US("us", "United States"),

   ZW("zw", "Zimbabwe");

   private String nameCode;

   private String displayName;

   private Country(String code, String name) {
       this.nameCode = code;
       this.displayName = name;
   }

   public String getNameCode() {
       return this.nameCode;
   }

   public String getDisplayName() {
       return this.displayName;
   }

   @Override
   public String toString() {
       return this.displayName;
   }

}