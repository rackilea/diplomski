for(int i=0; i< lstSpecialties.length; i++){
    String newString = "<AggregateColumn AggregateFunction="+"\"Sum\" "                                  +"ID="+"\"siteTotal#\"" + " AggregateColumn="+"\"@\" />";
    newString = newString.replace("#", lstSpecialties[i]);
    newString = newString.replace("@", lstSpecialties[i]);
    System.out.println(newString);
}