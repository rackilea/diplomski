// Get some user input from some screen's input field.
String userInput = (String)context.getVariable("sometextbox");

// Call your custom code with user input and return a url
String url = com.mycompany.getDownloadFileUrl(userInput);

// Set it to the runtime variable.
return url;