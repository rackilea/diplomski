//section for set sub total when page load
var r, i;
r = document.getElementsByClassName("data");
for(i=0;i<r.length; i++){
    r[i].getElementsByClassName("total")[0].innerHTML =
        r[i].getElementsByClassName("price")[0].innerText *
        r[i].getElementsByClassName("quantity")[0].value;
}


//function to update sub total when quantity changed
function total(element) {
    var tr = element.parentNode.parentNode;
    var price = tr.getElementsByClassName("price")[0].innerText;
    tr.getElementsByClassName("total")[0].innerHTML = price * element.value;
}

// function to sum all sub total
function sumTotal(){
  var tot = 0 ; //variable hold the sum
  var len = document.getElementsByClassName("total").length;
  for(var i =0; i<len; i++){ 
    tot += parseInt(document.getElementsByClassName("total")[i].innerText); 
  }
}