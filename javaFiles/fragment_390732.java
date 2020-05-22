public static void main(String[] args){
    String s = "ab.cd;ef[gi]ij,kl";
    for(String a : s.split("[.,;\\[\\]]")){
        System.out.println(a);
    }
}