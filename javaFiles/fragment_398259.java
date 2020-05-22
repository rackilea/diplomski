function myFunction() { 
    var element = document.getElementById("hiddenMenuDiv");
    if (element.style.display === "block") {
        element.style.display = "none";
    } else {
        element.style.display = "block";
    }
}