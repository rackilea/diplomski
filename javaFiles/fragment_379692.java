public void actionPerformed(ActionEvent ev){
    String id = "id field value is: " + fields.get(0).getText(); 
    String firstName = "firstName field value is: " + fields.get(1).getText(); 
    String lastName = "lastName field value is: " + fields.get(2).getText(); 

    System.out.println(id+ " " + firstName + " " + lastName);
}