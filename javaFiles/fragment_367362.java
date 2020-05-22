List rowValues = new ArrayList();
while (namesList.next()) {
    rowValues.add(namesList.getString(1));
}   
// You can then put this back into an array if necessary
contactListNames = (String[]) rowValues.toArray(new String[rowValues.size()]);