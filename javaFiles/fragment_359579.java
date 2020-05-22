function togglePassword(checkbox){
   if(checkbox.checked == true){
      document.getElementById("password").type = "text";
   }else{
      document.getElementById("password").type = "password";
   }
}