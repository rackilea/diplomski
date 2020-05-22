List<List<Integer>> bitLists = new ArrayList<ArrayList<Integer>>();

while((strLine = br.readLine()) != null) {
    //print the content to console
    System.out.println(strLine);
    int[] n1 = new int [8];

    for(int i =0;i < strLine.length();i++){
        //  System.out.println((strLine.charAt(i)));

         n1[i] = Integer.valueOf(strLine.substring(i, i+1)); 

    }

    List<Integer> al = new ArrayList<Integer>();
    for(int i = 0;i < n1.length; i++){
        al.add(0,1);  // dummy value for now 1st need to be changed
        al.add(1,0);  // dummy value for now 2nd need to be changed
        al.add(2, n1[0]);
        al.add(3,0);  // dummy value for now 4th need to be changed
        al.add(4,n1[1]);
        al.add(5,n1[2]);
        al.add(6,n1[3]);
        al.add(7,0);   // dummy value for now 8th need to be changed
        al.add(8,n1[4]);
        al.add(9,n1[5]);
        al.add(10,n1[6]);
        al.add(11,n1[7]);
    }
    bitLists.add(al);
}