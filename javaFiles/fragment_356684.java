PrintWriter writer = response.getWriter();
writer.print("<html>");
writer.print("<head>");
writer.print("<title>HelloWorld</title>");
writer.print("<body>");
writer.write("<div>");
// here to display the text
writer.write(br.readLine());//this will read the first line
writer.write("</div>");

//And for the second line 

writer.write("<div>");
// here to display the text
writer.write(br.readLine());//this will read the next line i.e. second line
writer.write("</div>");
writer.print("</body>");
writer.print("</html>");