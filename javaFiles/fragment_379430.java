public class Finalist{
    /* all the other code */

    @Override
    public String toString() {
        return "ID: " + id + ", Final Mark: " + degreeMark + ", Classification: " + degreeClass;
    }
}

public class ProcessDegreeMark {
    /** Writes all non BORDERLINE candidates in the file and outputs the skipped finalists to System.out */
    public static void saveToFileWithoutBorderline(List<Finalist> list, File file) {
        try (PrintStream out = new PrintStream(new FileOutputStream(file))){
            for(Finalist finalist : list) {
                if(finalist.calcBorderline()) {
                    System.out.println("Skip BORDERLINE candidate: "+finalist.toString());
                } else {
                    out.println(finalist.toString());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}