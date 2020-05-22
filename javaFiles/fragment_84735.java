import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class NewClass1 {
    public static void main(String[] args) {
        try {
            String oldFile = "Old.csv";
            String changeFile = "Change.csv";
            String newFile = "New.csv";
            Map<String,Person> personsList = readOldCsv(oldFile);
            personsList = getChangesfromChangeCsv(changeFile,personsList);
            writeNewCsvFile(newFile,personsList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    //read your old csv file line by line and create an object person 
    //and put it in a map with code as key and person itself as value
    //here assumed that your files are tab separeted '\t'; 
    //if not change to ';' or ',' according to your separator
    public static Map<String,Person> readOldCsv(String fileName) throws IOException{
        Map<String,Person> personsList = new HashMap<>();
        String [] nextLine;
        CSVReader reader = new CSVReader(new FileReader(fileName), '\t' ,'\'', 1);
        while ((nextLine = reader.readNext()) != null) {        
            personsList.put(nextLine[0],new Person(nextLine[0], nextLine[1], nextLine[2], nextLine[3]));
        }       
        return personsList;        
    }
    // read your change csv file and add or update persons depending on the change column
    public static Map<String,Person> getChangesfromChangeCsv(String fileName, Map<String,Person> personsList) throws IOException{            
        String [] nextLine;
        CSVReader reader = new CSVReader(new FileReader(fileName), '\t' ,'\'', 1);
        while ((nextLine = reader.readNext()) != null) { 
            switch(nextLine[0].toLowerCase()){
                case "add":
                    personsList.put(nextLine[1],new Person(nextLine[1], nextLine[2], nextLine[3], nextLine[4]));
                case "update":
                    personsList.get(nextLine[1]).setName(!nextLine[2].isEmpty()? nextLine[2]:personsList.get(nextLine[1]).getName());
                    personsList.get(nextLine[1]).setAddress(!nextLine[3].isEmpty()? nextLine[3]:personsList.get(nextLine[1]).getAddress());
                    personsList.get(nextLine[1]).setNumber(!nextLine[4].isEmpty()? nextLine[4]:personsList.get(nextLine[1]).getNumber());
                default:
                    System.out.println("unexpected entry");
            }                
        } 
        // use TreeMap to get a map sorted by key
        return new TreeMap<>(personsList);        
    }

    //write the values of the map into a new csv file
    private static void writeNewCsvFile(String filename,Map<String,Person> personsList) throws IOException {            
        CSVWriter writer = new CSVWriter(new FileWriter(filename,false), '\t',CSVWriter.NO_QUOTE_CHARACTER);
        for(Person p : personsList.values() ){
            String[] entries = {p.geCode(),p.getName(),p.getAddress(),p.getNumber()};
            writer.writeNext(entries);
        }                
        writer.close();                    
    }
}