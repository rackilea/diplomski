class Test
{
        public static void main(String ... args)
        {
                String s="Wed Feb 20 02:48:00 GMT+05:30 2019";
                String arr[]=s.split(" ");
                if (arr.length >=3)
                {
                        String result=arr[0]+" "+arr[2];
                        System.out.println(result);
                }
        }
}
$ java Test
Wed 20