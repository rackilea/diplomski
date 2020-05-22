package sample;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Renamed from the undescriptive 'Main':

public class PlayerDataStore {
    public static final String TEST_FILE_NAME = "stats.txt";

    public static void main(String[] args) throws FileNotFoundException,IOException {
        PlayerDataStore playerData = new PlayerDataStore();
        playerData.load(TEST_FILE_NAME);
        playerData.display();
    }

    // Names of the vitals and attributes.
    // Shifted from comments to usable data.
    // This is useful for displaying the values.

    private static String[] VITAL_NAMES = new String[] {
        "Last Name",
        "First Name",
        "Position",
        "Secondary Position",
        "Height",
        "Weight",
        "Age"
    };

    public static final int NUM_VITALS = VITAL_NAMES.length;

    private static String[] ATTR_NAMES = new String[] {
        "0 to 3 feet FGA",
        "3 to 10 feet FGA",
        "10 to 16 feet FGA",
        "16 feet to 3pt FGA",
        "3pt FGA",
        "0 to 3 feet FG",
        "3 to 10 feet FG",
        "10 to 16 feet FG",
        "16 to 3pt FG",
        "3pt FG",
        "TOV%",
        "Athleticism",
        "Clutch",
        "OReb%",
        "Steal%",
        "Block%",
        "DReb%",
        "Usage Rate",
        "Overall Rating"
    };

    public static final int NUM_ATTRS = ATTR_NAMES.length;

    //

    // Split the storage into separate 'vitals' and 'attributes' storage.
    // Putting both sets of data -- vitals, and attributes -- was a bit messy,
    // and seemed unnecessary.

    private Map<String, String[]> allPlayerVitals;
    private Map<String, String[]> allPlayerAttributes;

    // Moved static code, and other code which was under 'Main', to a descriptive method.

    // Unused values were removed.

    public void load(String filename) throws FileNotFoundException, IOException {
        // First load the line data, then process the data into the stores.

        // Note: Storing the line values into 'playerInfo' is not necessary:
        // The line values can be used directly to populate the vitals and
        // attributes.

        List<String> lines = Files.readAllLines( Paths.get(filename) );

        int lineAmount = lines.size();

        List<List<String>> playerInfo = new ArrayList<>(lineAmount);

        for ( String line : lines ) {
            String[] lineValues = line.split(",");
            playerInfo.add( Arrays.asList(lineValues) );
        }

        // Make space for the vitals and attributes ...

        allPlayerVitals = new HashMap<String, String[]>( lineAmount );
        allPlayerAttributes = new HashMap<String, String[]>( lineAmount );

        // Transfer data from the vitals and attributes into storage ...

        for ( List<String> nextInfo : playerInfo ) {
            String playerVitals[] = new String[NUM_VITALS];

            for ( int vitalNo = 0; vitalNo < NUM_VITALS; vitalNo++ ) {
                playerVitals[vitalNo] = nextInfo.get(vitalNo);
            }

            // 'playerVitals[0]' is the players last name, which is currently
            // a unique value.
            //
            // TODO: The uniqueness of the player last name seems overly
            //       optimistic.  A different key value may be needed

            allPlayerVitals.put( playerVitals[0], playerVitals );

            String playerAttributes[] = new String[19];

            for ( int attrNo = 0; attrNo < 19; attrNo++ ) {
                if ( (attrNo == 11) || (attrNo == 12) ) {
                    continue;
                }
                playerAttributes[attrNo] = nextInfo.get(NUM_VITALS + attrNo);
            }

            // Store the attributes using the player last name.

            allPlayerAttributes.put( playerVitals[0], playerAttributes );
        }
    }

    void display() {
        // Display all stored data.

        // Note: The order of entries is random, since it is an iteration across a
        //       hash mapping.

        for ( Map.Entry<String, String[]> vitalsEntry : allPlayerVitals.entrySet() ) {
            String playerLastName = vitalsEntry.getKey();
            String[] playerVitals = vitalsEntry.getValue();

            String[] playerAttributes = allPlayerAttributes.get(playerLastName);

            for ( int vitalNo = 0; vitalNo < playerVitals.length; vitalNo++ ) {
                System.out.println("[ " + vitalNo + " ] " + VITAL_NAMES[vitalNo] + ": " + playerVitals[vitalNo] );
            }

            for ( int attrNo = 0; attrNo < playerAttributes.length; attrNo++ ) {
                if ( (attrNo == 11) || (attrNo == 12) ) {
                    continue;
                }
                System.out.println("[ " + attrNo + " ] " + ATTR_NAMES[attrNo] + ": " + playerAttributes[attrNo] );
            }
        }
    }
}