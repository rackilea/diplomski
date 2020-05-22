@Test
public void testValidLetter() {
    String msg = "Method should return true if the character is a/A, c/C, g/G, or t/T";
    DNASequence newDNASequence = new DNASequence(testArrValid); // <-- use here
    assertEquals(msg, true, newDNASequence.isValidLetter('a'));
}