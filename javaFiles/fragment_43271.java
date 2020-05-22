class Ideone
{
 public static void main (String[] args) throws java.lang.Exception
 {
    List<Float> s = new ArrayList(Arrays.asList(1.2F, 1.3F, 5.4F, 6.5F));
    Float sum = 0F;

    for (int i=0; i< s.size(); i++) {
        sum+=s.get(i);
    }

System.out.println("Sum: "+sum+" and Avg: "+sum/(s.size()));
}   
}