public class WordsClass {

    final public Object[][] finalTest;
    private int nElems;

    public WordsClass(String theDay, String theMonth, String theName, String theScore) {
        finalTest = new Object[14][4];
        nElems = 0;
    }

    public Object myObject(String a, String b, String c, String d) {
        finalTest[nElems][0] = Integer.parseInt(a);
        finalTest[nElems][1] = Integer.parseInt(b);
        finalTest[nElems][2] = c;
        finalTest[nElems][3] = Integer.parseInt(d);
        nElems++;
        return finalTest;
    }
}