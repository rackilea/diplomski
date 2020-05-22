String cow[][] = new String[5][5];

    cow[0][0] = "big";
    cow[0][1] = "smallest";
    cow[0][2] = "small";
    cow[0][3] = "medium";
    cow[0][4] = "biggest";

    cow[1][0] = "smallest";
    cow[1][1] = "biggest";
    cow[1][2] = "medium";
    cow[1][3] = "small";
    cow[1][4] = "big";

    cow[2][0] = "medium";
    cow[2][1] = "biggest";
    cow[2][2] = "big";
    cow[2][3] = "smallest";
    cow[2][4] = "small";

    cow[3][0] = "small";
    cow[3][1] = "big";
    cow[3][2] = "smallest";
    cow[3][3] = "medium";
    cow[3][4] = "biggest";

    cow[4][0] = "biggest";
    cow[4][1] = "medium";
    cow[4][2] = "big";
    cow[4][3] = "small";
    cow[4][4] = "smallest";

    for (int i = 0; i < cow.length; i++) {
        List<String> list = new ArrayList<>(); //list for saving each row
        for (int j = 0; j < cow[i].length; j++) {

            list.add(cow[i][j]);

        }
        Collections.sort(list); // sort array
        Collections.reverse(list); // reverse array just for better order
        String big = list.get(4);  // since the biggest comes befor big
        list.set(4, list.get(3)); // we need to change them
        list.set(3, big);

        for(int x=0;x<list.size();x++){
if(x<list.size()-1){  System.out.print(list.get(x)+" | "); }
else { System.out.println(list.get(x)); } }

    } // end of outer loop