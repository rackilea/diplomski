public class Split
{
    public static void main (String[] args) {
      String SPACE_K = " ";
      String SEPARATOR_K = ",";

      String input = "15018,738,25094548 47137,77,1479107 80595,70,740157 38834,90,5419316 59382,82,2431554 865303,1,4 158088,44,56662 139671,61,325746 530224,5,410 783,99,14400482 268478,20,4981 577948,1,30 684122,1,40 222912,37,27987 598052,1,18 614235,1,40 69690,48,85643 235186,32,17801 329817,14,2179 118561,50,102391 380170,1,0 376338,1,0 374930,1,0 335953,1,0";
      String[] numbers = input.split(SPACE_K);
      for (int i=0; i<numbers.length; i++) {
        String number = numbers[i];
        String[] values = number.split("\\"+SEPARATOR_K );
        if (values!=null && values.length==3) {
            Skill skill = new Skill(values[0], values[1], values[2]);
            System.out.println("\nCreated new object "+ skill.toString());
        }
      }
    }

    public static class Skill {
        private final String val1, val2, val3;

        public Skill(String in1, String in2, String in3)  {
          val1 = in1; val2 = in2; val3 = in3;
        }

        public String toString() {
          return "Skill ("+ val1 + ", " + val2 + ", " + val3 + ")";
        }        
    }
}