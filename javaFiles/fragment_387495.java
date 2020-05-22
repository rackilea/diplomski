@Test
public class TestConstantUniqueness() {
    Set<String> stringValues = new HashSet<String>();
    for (MyConstantEnum value : MyConstantEnum.values()) {
        String s = value.stringValue();
        Assert.assertTrue(
            "More than one constant in " + MyConstantEnum.class
                + " has the string value \"" + s + "\"",
            stringValues.add(s));
    }
}