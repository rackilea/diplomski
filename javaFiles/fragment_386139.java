import java.io.BufferedReader;
import java.io.StringReader;
import java.util.HashMap;

public class CSVMapper {

    public String transformCsv (String csvFile) {
        return csvMapToString(getCsvMap(csvFile));
    }

    private HashMap<String, Integer[]> getCsvMap (String csvFile) {
        // <K,V> := <Company, [Downloaded, Watched, Subscribed]>
        HashMap<String, Integer[]> csvMap = new HashMap<String, Integer[]>();
        BufferedReader reader = new BufferedReader(new StringReader(csvFile));
        String csvLine;

        // Create map
        try {
            while ((csvLine = reader.readLine()) != null) {
                String[] csvColumns = csvLine.split(",");
                if (csvColumns.length > 0) { 
                    try {
                        String company = csvColumns[0].trim();
                        String actionsType = csvColumns[1].trim();
                        Integer[] columnValues = csvMap.get(company);

                        if (columnValues == null) {
                            columnValues = new Integer[3];
                            columnValues[0] = columnValues[1] = columnValues[2] = 0;
                        }
                        columnValues[0] = columnValues[0] + (actionsType.equals("Downloaded") ? 1 : 0);
                        columnValues[1] = columnValues[1] + (actionsType.equals("Watched")    ? 1 : 0);
                        columnValues[2] = columnValues[2] + (actionsType.equals("Subscribed") ? 1 : 0);

                        if (!company.equals("Company"))
                            csvMap.put(company, columnValues);
                    }
                    catch (Exception nfe) {
                        //TODO: handle NumberFormatException
                    }
                }
            }
        }
        catch (Exception e) {
            //TODO: handle IOException
        }
        return csvMap;
    }

    private String csvMapToString (HashMap<String, Integer[]> csvMap) {
        StringBuilder newCsvFile = new StringBuilder(); 
        newCsvFile.append("Company, Downloaded, Watched, Subscribed\n");
        for (String company : csvMap.keySet()) {
            Integer[] columnValues = csvMap.get(company); 
            newCsvFile.append(company + 
                              ", " + Integer.toString(columnValues[0]) +
                              ", " + Integer.toString(columnValues[1]) +
                              ", " + Integer.toString(columnValues[2]) + "\n");
        }
        return newCsvFile.toString();
    }

    public static void main (String[] args) {
        String csvFile = "Company, ActionsType, Action\n" +
                     "ABC, Downloaded, Tutorial 1\n" +
                     "ABC, Watched, Tutorial 2\n" +
                     "PQR, Subscribed, Tutorial 1\n" +
                     "ABC, Watched, Tutorial 2\n" +
                     "PQR, Subscribed, Tutorial 3\n" +
                     "XYZ, Subscribed, Tutorial 1\n" +
                     "XYZ, Watched, Tutorial 3\n" +
                     "PQR, Downloaded, Tutorial 1";

        System.out.println( (new CSVMapper()).transformCsv(csvFile) );
    }
}