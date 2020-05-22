public static void hello(String txtName, Integer txtAge) {
     validation.required(txtName);
     validation.required(txtAge);
     validation.min(txtAge, 18);

     if(validation.hasErrors()) {
         for(Error error : validation.errors()) {
             System.out.println(error.message());
         }
     }
}