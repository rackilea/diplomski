String originArea = "";
for(int i=0; i<areaNumbers.length; i++) {
    int compareMe = areaNumbers[i];
    if( compareMe == area) { 
        originArea = locations[i];
        break; 
    }
}

System.out.println("You are from: " + originArea);