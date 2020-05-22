public class Company {

     /* this specifies that 
      * it is a mandatory field in the csv, 
      * of header name "Company Name" and 
      * of type string. 
      * Header is the first line of the csv.
      */
     @ImportField(mandatory = true, name = "Company Name", type = "String")
     public String name;

     @ImportField(mandatory = true, name = "Name of the CEO", type = "String")
     public String ceoName;    
 }