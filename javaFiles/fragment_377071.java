ArrayList<String> tempList = new ArrayList<String>();   
for(int i = 0; i < allChars.size(); i++) {             
    for(int k = 0; k < usedChars.size(); k++) {        
        if(!allChars.get(i).equals(usedChars.get(k))) { 
            tempList.add(allChars.get(i));             
        }
    }
}