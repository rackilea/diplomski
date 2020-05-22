//initialize variables
    HashMap<String,ArrayList<Integer>> hm=new HashMap();
    ArrayList<Integer> values=new ArrayList<Integer>();
    values.add(0);
    values.add(1);
    values.add(2);
    hm.put("ko4", values);
    System.out.println(hm.get("ko4").get(0));//prints index 0
    System.out.println(hm.get("ko4").get(1));//prints index 1
    System.out.println(hm.get("ko4").get(2));//prints index 2

}