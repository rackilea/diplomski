public class Readtextfile {


    public static void main(String[] args) throws FileNotFoundException {

            Scanner read = new Scanner(new File("read.txt"));
            read.useDelimiter("\n"); // It is the default delimiter, you can skip this line.

            while(read.hasNext()){
                 String str= read.next().replaceAll(";","");
                 System.out.println(str));

            }

        }

    }