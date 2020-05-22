function validation(){
var a=document.getElementById("name");
  if (a.value==""){
    alert("Name can't be empty");
    return false
    }
   else
     return true;
}