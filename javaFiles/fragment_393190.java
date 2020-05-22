data = {2165: "Money sent successfully", 2167: "Something went wrong"};
var idx = 0; 
var key = Object.keys(data)[idx];
var value = data[key]
console.log(value);
$('.currentBalance').text(value);