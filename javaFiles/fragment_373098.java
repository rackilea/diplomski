try {
    int value = Integer.parseInt(test);
}
catch (NumberFormatException e) {

    try {

        double value2 = Double.parseDouble(test);
    }
    catch (NumberFormatException ex) {

            ... and so on ... 
    }
}