// Parse the html string into a document
Document doc = Jsoup.parse(getHTML_String(), "UTF-8");

// Get the table you want to remove and the first row
Element rowToRemove = doc.getElementsByTag("tr").get(5);
Element firstRow = doc.getElementsByTag("tr").get(0);

// Create an element for the row you want to add    
Element rowToAdd = new Element("tr");
rowToAdd.html("<td>19-Mar 7.00 PM</td> <td>4</td> <td>31</td> <td>50181</td> <td>555</td>");

// Add that new row after the first row element
firstRow.after(rowToAdd);

// Remove the unwanted row from the doc 
rowToRemove.remove();

System.out.println(doc.html());