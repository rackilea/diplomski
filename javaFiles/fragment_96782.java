@Test
public void testTemp() {
    String regex = "[^.][*]";
    if ("s*".matches(regex)) {
        if (!".*".matches(regex)) {
            System.out.println("Success");
        } else {
            // This exception gets thrown.
            throw new RuntimeException("Wrongly matches dot star");
        }
    } else {
        throw new RuntimeException("Does not match star");
    }
}