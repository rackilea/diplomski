public class Main {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    OrderTransactions[] obj = new OrderTransactions[5];
    String info;

    for(int i = 0; i < obj.length; i++) {
        System.out.println("Enter input as: 'num;loc;co;val'");
        info = sc.nextLine();
        String[] parts = info.split(";");
        obj[i] = new OrderTransactions(parts[0], parts[1], parts[2], parts[3]);
    }

    ArrayList<String> costs = new ArrayList<String>();
    for(int i = 0; i < obj.length; i++)
        costs.add(obj[i].val);
    int tot = totalAmount(costs);

    System.out.println("Total Amount: " + tot);
}
public static int totalAmount(ArrayList<String> x) {
    HashMap<Character,Double> hm = new HashMap<Character,Double>();
    for(int i = 0; i < x.size(); i++) {
        String[] s = x.get(i).split("(?<=\\d)(?=[a-zA-Z])");
        hm.put(s[1].charAt(0), Double.parseDouble(s[0]));
    }

    double[] nums = new double[5];
    int i = 0;
    for(Map.Entry<Character,Double> pair : hm.entrySet()) {
        switch(pair.getKey()) {
            case 'M' :
                nums[i] = pair.getValue() * 1000000;
                break;
            case 'K' :
                nums[i] = pair.getValue() * 1000;
                break;
            case 'H' :
                nums[i] = pair.getValue() * 100;
                break;
            default :
                System.out.println("Info did not have correct following letter");
                break;
        }
        System.out.println(nums[i]);
        i++;
    }

    int tot = 0;
    for(int j = 0; j < nums.length; j++)
        tot += nums[j];

    return tot;
}
public static class OrderTransactions {
    String no;
    String loc;
    String co;
    String val;

    public OrderTransactions(String n, String l, String c, String v) {
        no = n;
        loc = l;
        co = c;
        val = v;
    }


}
}