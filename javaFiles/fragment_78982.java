function selectAll(){
    var cartOptions = document.getElementById("cart").getElementsByTagName("option");
    for(var i=0;i<cart.length;i++){
        cartOptions[i].setAttribute("selected","true");
    }
}