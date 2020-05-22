String searchQuery = scanner.next();
int indexFound = -1;
for(int x = 0; x < arrName.length; x++) {
    if(arrName[x] != null && (arrName[x].toLowerCase().equals(searchQuery.toLowerCase()) || arrName[x].toLowerCase().contains(searchQuery.toLowerCase())) {
        indexFound = x;
        break;
    }
}

if(indexFound != -1) {
    System.out.println("Monster Found by the name of " + searchQuery)
    System.out.println("name         : \"" + arrName[indexFound] + "\"");
    System.out.println("hit point    :" + arrHP[indexFound]);
    System.out.println("attack point :" + arrAP[indexFound]);
    System.out.println("defense point:" + arrDP[indexFound]);
    System.out.println("level        :" + LEVEL[indexFound] + "(" + arrHP[indexFound] + "/" + arrAP[indexFound] + "/" + arrDP[indexFound] + ")");
} else {
    System.out.println("Monster not found");
}