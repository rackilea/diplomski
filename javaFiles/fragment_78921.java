protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/plain");
    PrintWriter out = resp.getWriter();

    StringBuilder stringBuilder = new StringBuilder(1000);
    Scanner scanner = new Scanner(req.getInputStream());
    while (scanner.hasNextLine()) {
        stringBuilder.append(scanner.nextLine());
    }

    String body = stringBuilder.toString();

    System.out.println(body);
    out.println(body);

}