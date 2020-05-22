List<String> listA = Arrays.asList("Please Select...", "DEP900", "DEP800", "DEP700", "DEP600", "DEP400", "DEP300", "DEP200", "DEP100", "DEP500", "DEP1000");
List<String> listB = new ArrayList();
List<Element> options = driver.getElements(AppObjects.Basic1_Dropdown);
for(Element opt : options){
   String actualtext = opt.getText();
   listB.add(actualtext);
}
Assert.assertEquals(listB, listA);