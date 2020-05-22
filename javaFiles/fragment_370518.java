Double currIn = null, convert = null;
try {
    currIn = Double.parseDouble(request.getParameter("txtCurrency1"));            
    convert = fxDataModel.getFxRate(curr1,curr2)*currIn;
}
catch (NumberFormatException ex){ 
    errorMessage = "Please insert a valid number!";
}