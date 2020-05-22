public void doPost(HttpServletRequest req, HttpServletResponse res) {

   BufferedReader reader = req.getReader();
   String line = reader.readLine();
   System.out.println("servlet received text: " + line);

}