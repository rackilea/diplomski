public class StockistServiceImpl {
    ...
    BuildFileReader bfr = new BuildFileReader();

    FileReader fileReader = bfr.getReader(xyz); 

    fileReader.readFile(fileName, codeDetails);
    ...
}