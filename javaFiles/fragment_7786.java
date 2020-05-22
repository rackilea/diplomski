import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TimeMachine extends Applet implements ItemListener{
    private static final long serialVersionUID = 1L;

    private List listRegion = new List();
    private List listSubRegion = new List();
    private Map<String, Set<String>> regionCountryMap = new HashMap<String, Set<String>>();

    public void init()
    {
        setLayout(new BorderLayout());

        getLocationInfo();
        Panel buttons = new Panel(new BorderLayout());
        buttons.setBackground(Color.cyan);
        buttons.add(listRegion, BorderLayout.WEST);
        buttons.add(listSubRegion, BorderLayout.CENTER);
        add(buttons, BorderLayout.NORTH);
    }

    private void getLocationInfo() {
        String fileName = "e:\\regions.csv";
        File file = new File(fileName);
        try {
            Scanner inputStream = new Scanner(file);
            inputStream.useDelimiter(System.getProperty("line.separator"));
            listRegion = new List();
            while (inputStream.hasNext())
            {
                String data = inputStream.next(); // gets the whole line
                String[] arrayLocations = data.split(",");
                if(arrayLocations.length != 2){
                    System.out.println("Invalid entry in file : "+ Arrays.toString(arrayLocations));
                    continue;
                }
                String region = arrayLocations[0];
                if(!regionCountryMap.containsKey(region))
                {
                    listRegion.add(region);
                    regionCountryMap.put(region, new HashSet<String>());
                }
                regionCountryMap.get(region).add(arrayLocations[1]);//Set handles duplicates as well
            }
            inputStream.close();
            System.out.println("Region, Country list has been parsed successfully");
            listRegion.addItemListener(this);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Set<String> countries = regionCountryMap.get(listRegion.getSelectedItem());
        listSubRegion.removeAll();
        for(String country : countries) {
            listSubRegion.add(country);
        }
        listSubRegion.validate();
        listSubRegion.repaint();
    }
}