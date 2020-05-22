int[][] list = {{2,3,5,10,13}, {12,23,9,8}, {34,11,14,15,67,28,5}, {7,23,67,27,30,33}};
HashSet<Integer> seenItems = new HashSet<>();
for(int i = 0; i < list.length; i++) {
    int[] l = list[i];
    for(int j = 0; j < l.length; j++) {
        int itemToCheck = l[j];
        if (seenItems.contains(itemToCheck)) {
            System.out.println("We've already seen " + itemToCheck);
            return;
        } else {
            seenItems.add(itemToCheck);
        }
    }
 }