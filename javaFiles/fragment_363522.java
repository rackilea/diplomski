private int findIndex(String id) {
    int noIndex = -1;
    for (int i = 0; i < ids.length; i++) {
       if (ids[i].equalsIgnoreCase(id)) {
          System.out.println("The index of this student is " + i);
          return i;
       }
    }
    System.out.println(noIndex);
    return noIndex;
}