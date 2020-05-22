// Send a GET request to the Servlet, to write a new image from the webcam.
function invokeServlet() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4) {
            refreshImage();
        }   
    };
    xhttp.open("GET", "startCCTV.do", true);
    xhttp.send();
}