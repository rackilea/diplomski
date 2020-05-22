public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Map<String, Integer> map = new HashMap<>();
    System.out.println("Elemment number: ");
    String sNum = input.nextLine();
    int iNum = Integer.parseInt(sNum);
    for (int i = 0; i < iNum; i++) {
        String sKey ;
        do {
            System.out.println("Key: ");
            sKey = input.nextLine();
        } while (map.containsKey(sKey));

        System.out.println("Value: ");
        String sValue = input.nextLine();
        int iValue = Integer.parseInt(sValue);
        map.put(sKey, iValue);
    }
 }