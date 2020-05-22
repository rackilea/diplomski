System.out.println("<ingredients>");
Vector ingredients;
for (String name : ingredients) {
  System.out.print("  <ingredient name=\"");
  System.out.print(name);
  System.out.println("\"/>");
}
System.out.println("</ingredients>");