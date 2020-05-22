public static void main(String[] args) {
    List<Integer> numList = new ArrayList<>();
    initializeList(numList);
    System.out.println("Num of integer in list: "+numList.size());
 }
 public static void initializeList(List<Integer> numList) {
    Scanner sc = new Scanner(System.in);
    boolean flag = true;
    while(flag) {
        int num = sc.nextInt();
        if(num==-1) {
           flag = false;
        }else {
           numList.add(num);
        }
    }
    sc.close();
 }