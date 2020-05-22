String zipcode = "";
String currentUrl = "https://www.loca.com/usa/test/#/xxx"
//This will check to make sure USA is a part of the URL, and doesn't exist as another part of the URL.
if(currentUrl.contains("/usa/")){
   zipcode = "12345";
//Same here with Canada
} else if(currentUrl.contains("/canada/"){
   zipcode = "ab1233"; 
//You can continue pattern for any other countries
} else if(currentUrl.contains(...){
...