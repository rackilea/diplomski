ArrayList<String> tempList = new ArrayList<String>();
for(int i = 0; i < allChars.size(); i++) {             
    if (!usedChars.contains(allChars.get(i))) {
        tempList.add(allChars.get(i));                  
    }
}