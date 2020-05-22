//Just for Demo purpose
function getRating() {
    var number = prompt("Enter the rating?");
    if(number *= 1 > 0  && number <=5) {
        show_image('yr', number);
    } else {
        alert("Enter valid rating, greater than 0");
    }
}

function show_image (id,number) {
    document.getElementById(id).innerHTML = '';
    for (var i =0; i<number; i++){
        var img = document.createElement("img");
        img.height=10;
        img.src = "http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/512/star-full-icon.png";
       document.getElementById(id).appendChild(img);
    }
}