String [] anArray = new String[10];
String [] anArray2 = new String[10];
String [] anArray3 = new String[10];
List<String[]> kList = new ArrayList<String[]>();
kList.add(anArray);
kList.add(anArray2);
kList.add(anArray2);

for (String[] arr : kList) {
    // Perform actions or pass the `arr` value
    // This will go through each array in kList and store the array
    // in arr so you can process each array independently
}