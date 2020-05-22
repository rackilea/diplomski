// This will track your current row later on
count = 0;

// Create instance of the Controller class
controller = new Packages.com.your.package.path.DataSetController(); 

//Load the rows (Note here is where you are able to pass your parameter into the Java layer)
rows = controller.getRows(params["myParameter"]);