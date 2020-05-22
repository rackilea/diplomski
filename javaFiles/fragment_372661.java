<body>
    <%
    String id = request.getParameter("id");
    String fileName = "/"+id.replaceAll(" ", "")+".txt"; // avoiding null check of 'id' for simplicity
    Scanner sc = new Scanner(new File(application.getRealPath(fileName)));
    try {
        while(sc.hasNext()) {

    ........
    ........