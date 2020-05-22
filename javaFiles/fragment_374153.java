// Use CSS selectors to select the table header elements that correspond
// to the table data rows we want to select (i.e. team name and wins)
Element teamNameElement = doc.select("th.Standings-header-team").first();
Element winsElement = doc.select("th[title='Match Wins']").first();

// Get the index within the table header that the elements are at 
// (will be used to find the appropriate table data in the table row).
int teamNameIndex = teamNameElement.elementSiblingIndex();
int winsIndex = winsElement.elementSiblingIndex();

// Select the first table row. This contains the data we want to grab.  
Element tableRow = doc.select("tbody > tr").first();

// Use the indexes we found earlier to get the team name and wins <td> elements
Element teamNameData = tableRow.getElementsByIndexEquals(teamNameIndex).first();
Element winsData = tableRow.getElementsByIndexEquals(winsIndex).first();

// There are multiple span elements in the team name <td> so grab the one
// at index 1 which contains the name.  
Element name = teamNameData.select("span").get(1);

System.out.println("Team Name: " + name.text());
System.out.println("Wins: " + winsData.text());