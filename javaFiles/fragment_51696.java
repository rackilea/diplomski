public static void main(String[] args)
{
    String test = "Hello World";
    for(int i = 0; i < test.length()*3; i++)
        System.out.println(cyclicLeftShift(test, i));
}