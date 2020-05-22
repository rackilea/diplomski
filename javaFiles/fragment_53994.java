private void printOutput(HttpServletResponse response, String msg3) {
    PrintWriter out = response.getWriter();
    out.print("<html>");
    out.print("<head>");
    out.print("<title>Value Convertor</title>");
    out.print("</head>");
    out.print("<body><br>");
    out.print("<h1>" + msg + "</h1>");
    out.print("</body>");
    out.print("<html>");
}

if (currencyCode.equals("") && currencyValue.equals("")) {
    printOutput(response, "ERROR! Code and Value are not set. Please enter Code and Value you want to exchange.");
    System.out.println(
            "ERROR! currencyCode and currencyValue are not set. Please enter Code and Value you want to exchange.");
} else if (currencyCode.equals("")) {
    printOutput(response, "ERROR! Code is not set. Please enter Code you want to exchange.</h1>");
    System.out.println("ERROR! currencyCode is not set. Please enter Code and Value you want to exchange.");
} else if (currencyValue.equals("")) {
    printOutput(response, "ERROR! Value is not set. Please enter Value se we can exchange your currency.</h1>");
    System.out.println("ERROR! currencyValue is not set. Please enter Code and Value you want to exchange.");
}