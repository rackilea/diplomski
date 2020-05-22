public class Main {


    public  static Comparable[][] findCommonElements(Comparable[][] collections){


        for(int i = 0; i < collections.length; i++){
            Arrays.sort(collections[i]);

        }

        return collections;
    } 

   public static void main(String[] args) {

    Character [][]input= {{'Z','C','D'},{'B','F','E'},{'D','Z','A' }};

    Comparable[][] output = findCommonElements(input);

    for(int i = 0; i <output.length; i++){
        System.out.print(Arrays.toString(output[i]) + "\n");
    }     
  }
}