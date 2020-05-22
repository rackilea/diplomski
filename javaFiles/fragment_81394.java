function checkFields(){
  var user = document.getElementById('username').value; 
  var pass = document.getElementById('password').value;

  if (user == "" || pass == ""){
    alert("Username and Password required");
  }
  else{
    document.getElementById("myForm").submit();
  }
}