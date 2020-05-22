class BaseConvert
    {

        public static int baseTen(String s, int base){

            String[] bits = s.split("");
            int result = 0;

            for (int i = 0; i < bits.length; i++ ){

                int val = (Integer.parseInt(bits[bits.length-1-i])) * ((int)Math.pow(base,i));

                result += val;
            }

            return result;
        }

        public static void main(String[] args)
        {
                 System.out.println(baseTen("1111",2));
        }
    }