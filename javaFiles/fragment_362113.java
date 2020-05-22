import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.TextFilterator;
import ca.odell.glazedlists.matchers.TextMatcherEditor;
import ca.odell.glazedlists.swing.AutoCompleteSupport;
import ca.odell.glazedlists.swing.EventComboBoxModel;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StationFinderAutoComplete {

    private JFrame mainFrame;
    private JComboBox stationsComboBox;
    private EventList<Station> stations = new BasicEventList<Station>();

    public StationFinderAutoComplete() {
        populateStations();
        createGui();
        mainFrame.setVisible(true);
    }

    private void populateStations() {
        stations.add(new Station("Key 103", "Manchester"));
        stations.add(new Station("Capital FM", "London"));
        stations.add(new Station("BBC Radio Leeds", "Leeds"));
        stations.add(new Station("BBC Radio 4", "London"));
    }

    private void createGui() {
        mainFrame = new JFrame("GlazedLists Autocomplete Example");
        mainFrame.setSize(600, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use a GlazedLists EventComboBoxModel to connect the JComboBox with an EventList.
        EventComboBoxModel<Station> model = new EventComboBoxModel<Station>(stations);
        stationsComboBox = new JComboBox(model);

        AutoCompleteSupport autocomplete = AutoCompleteSupport.install(stationsComboBox, stations, new StationTextFilterator());
        // Try without the filterator to see the difference.
        //AutoCompleteSupport autocomplete = AutoCompleteSupport.install(stationsComboBox, stations);
        autocomplete.setFilterMode(TextMatcherEditor.CONTAINS);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(stationsComboBox, BorderLayout.NORTH);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.getContentPane().add(panel, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StationFinderAutoComplete();
            }
        });
    }

    class Station {

        private String title;
        private String location;

        public Station(String title, String location) {
            this.title = title;
            this.location = location;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        @Override
        public String toString() {
            return title + " (" + location + ")";
        }
    }

    class StationTextFilterator implements TextFilterator<Station> {
        @Override
        public void getFilterStrings(List<String> baseList, Station station) {
            baseList.add(station.getTitle());
        }
    }
}