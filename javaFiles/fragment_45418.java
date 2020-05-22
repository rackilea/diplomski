ArrayList<Integer> r;
ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

for(int i = 0; i < 5; i++){

    r = new ArrayList<>();

    for(int ir = 0; ir <= i; ir++) {

        r.add(ir);

    }

    ans.add(r);

}

System.out.println(ans.toString());
//OUTPUT : [[0], [0, 1], [0, 1, 2], [0, 1, 2, 3], [0, 1, 2, 3, 4]]