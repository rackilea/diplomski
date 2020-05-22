public class readtxtfile
{
    public static void main(String[] args)
    {
        int[] histogram = new int[10];
        File file = new File("data.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;
            while ((text = reader.readLine()) != null) {
                int num = Integer.parseInt(text);
                int inRange = (num-1)/10;
                histogram[inRange] = histogram[inRange] + 1;
            }
            for(int i=0;i<10;i++) {
                System.out.print("\n"+((i*10)+1)+" - "+((i+1)*10)+" : ");
                for(int j=0;j<histogram[i];j++) {
                    System.out.print("*");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}