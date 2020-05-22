for (int i = 0; i < checkboxNamesList.length; i++) {

    String myCheckBoxValue = request.getParameterValues(checkboxNamesList[i]);

    // if null, it means checkbox is not in request, so unchecked 
    if (myCheckBoxValue == null)
        writer.append(checkboxNamesList[i] + "=unchecked");

    // if is there, it means checkbox checked
    else
        writer.append(checkboxNamesList[i] + "=checked");

}