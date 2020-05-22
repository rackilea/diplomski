public void calculate(){
if (isValidOrder){ //if its a vaild order
    Total = Quantity * Price; 

}
else{ //if not valid order this will run 
    Message = "Error: order number: "+OrderNum + " cannot be totalled as it is invaild";
    isDiscounted = false; 
}


if (isDiscounted){ // runs if order is discounted
    Total = Quantity * Price - Quantity * Price * (Discount/100); 


}
 /*else{ //if not  discounted then this will run
    Total= Quantity * Price; */
}