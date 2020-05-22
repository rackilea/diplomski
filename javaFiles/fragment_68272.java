public class DERstring{

        public enum Fertigkeit 
        {
         UEBER("Überreden"), 
         HEIML("Heimlichkeit"),
         SUCHE("Suchen");

         private String name;

         private Fertigkeit(String name){
            this.name=name;
         }

         public String getName() {
            return name;
         }

    }

.....other enums classes...