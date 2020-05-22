public static void main (String[] args) throws java.lang.Exception
{
    // your code goes here
    Scanner scan = new Scanner(System.in);
    String s = scan.nextLine();
    String[] splitted = s.split(",");
    for(int i = 0; i < splitted.length;i++){
        if(splitted[i].contains("-")){
            String[] nums = splitted[i].split("-");
            int from =  Integer.parseInt(nums[0]);
            int to = Integer.parseInt(nums[1]);
            for(int j = from;j <= to;j++)
                System.out.print(j+",");
        }
        else
            System.out.print(splitted[i] + ",");

    }