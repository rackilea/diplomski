package get_alternatenames;

import java.io.BufferedReader;
import java.io.FileReader;

import com.mongodb.Mongo;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import java.util.Set;

/**
 *
 * @author cbmeeks
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String alternateNamesFileName = "/Users/cbmeeks/Projects/GetData/geonames/alternateNames.txt";
        String line;

        // MongoDB
        Mongo m = new Mongo("localhost", 27017);
        DB db = m.getDB("MyDB");

        // Build AlternateNames
        DBCollection altNames = db.getCollection("alternatenames");
        BufferedReader bReader = new BufferedReader(new FileReader(alternateNamesFileName));

        int isPreferredName = 0;
        int isShortName = 0;
        int lines = 0;

        System.out.println("Starting AlternateNames import...");

        while ((line = bReader.readLine()) != null) {
            try {
                String l[] = line.split("\t");
                if (l.length >= 4) {
                    BasicDBObject altName = new BasicDBObject();
                    altName.put("alternateNameId", Integer.parseInt(l[0]));
                    altName.put("geonameId", Integer.parseInt(l[1]));
                    altName.put("isoLanguage", l[2]);
                    altName.put("alternateName", l[3]);

                    isPreferredName = 0;
                    isShortName = 0;

                    if (l.length == 5) {
                        isPreferredName = Integer.parseInt(l[4]);
                    }

                    if (l.length == 6) {
                        isPreferredName = Integer.parseInt(l[4]);
                        isShortName = Integer.parseInt(l[5]);
                    }

                    altName.put("isPreferredName", isPreferredName);
                    altName.put("isShortName", isShortName);

                    altNames.insert(altName);

                    lines++;
                }
            } catch (Exception ex) {
            }

        }

        bReader.close();
        System.out.println("Number of lines parsed: " + lines);

        System.out.println("Creating indexes...");
        altNames.createIndex(new BasicDBObject("geonameId", 1));
        altNames.createIndex(new BasicDBObject("isoLanguage", 1));
        altNames.createIndex(new BasicDBObject("alternateName", 1));

    }
}