public class Main {

public static void main(String[] args) throws FileNotFoundException, IOException {


    String PATH_2_FOLDER = "path_2_folder";

    //listing all files in the desired folder
    File myDirectory = new File(PATH_2_FOLDER);
    File[] allFiles = myDirectory.listFiles();

    System.out.println(allFiles.length);

    for (int l = 0; l < allFiles.length; l++) {

        if (allFiles[l].getName().endsWith(".txt")) {


            //read the input file
            String thisPathIn = PATH_2_FOLDER+allFiles[l].getName();
            BufferedReader thisBR = new BufferedReader(new FileReader(thisPathIn));


            //create the output file
            String newName = allFiles[l].getName().replace(".txt", "").concat(".new.txt");
            String thisPathOut = PATH_2_FOLDER+newName;
            BufferedWriter thisBW = new BufferedWriter(new FileWriter(thisPathOut));


            //read the contents of the inputfile
            String s = "";
            while((s = thisBR.readLine()) != null){

            //process the content
            //...
            //create new content


            thisBW.write("new_content\n");

            }

            thisBW.flush();
            thisBW.close();

        }

    }

}
}