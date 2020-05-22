// get user input from input field..
var userInput = document.getElementById("#my-input").value;

xmlHttp = new XMLHttpRequest();
//         HTTP Method, URL, async
xmlHttp.open('POST', '/myJavaEndPoint', true);
// create onreadystatechange callback function,
// it gets called everytime the readyState changes..
xmlHttp.onreadystatechange = function () {
    // readyState 4 means "DONE" - request is complete, responseText now contains the full response..
    if (xmlHttp.readyState == 4) {
        alert(xmlHttp.responseText); // Show the result to the user. 
    }
};
xmlHttp.send(userInput); // Start Request, send the user input as post-payload