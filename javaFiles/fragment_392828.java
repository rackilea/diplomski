public enum decizion{
     YES("Y"), NO("N"), OTHER;

     String key;

     decizion(String key) { this.key = key; }

     //default constructor, used only for the OTHER case, 
     //because OTHER doesn't need a key to be associated with. 
     decizion() { }

     decizion getValue(String x) {
         if ("Y".equals(x)) { return YES; }
         else if ("N".equals(x)) { return NO; }
         else if (x == null) { return OTHER; }
         else throw new IllegalArgumentException();
     }
}