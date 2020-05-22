@Test
public void testIntegerValue() {
    Integer num = new Integer(1);
    setInteger(num);
    System.out.println(num); // still return one, why? because Integer will convert to 
                            // int internally and int is primitive in Java, so it's pass by value

}

public void setInteger(Integer i) {
    i +=1;
}