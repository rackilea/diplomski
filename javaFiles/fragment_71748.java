// LinkedHashSet assigned to widgetsToCreate 
LinkedHashSet<String> widgetsToCreate = new LinkedHashSet<String>();

// widgetsToCreate is not used
for (Map.Entry<String, String> entry : input.entrySet()) {
  //logic to add to widgetsToAdd based on content of the input Map
}

// new value assigned to widgetsToCreate, the LinkedHashSet assigned before wasn't used
widgetsToCreate = processInput(widgetsToAdd);