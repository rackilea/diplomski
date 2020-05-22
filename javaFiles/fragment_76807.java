import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        new Display();                        // <-- just instantiate
    }

}

 class Display {

    Display disp = this;

    public JPanel myPanel;               // <--------- Haven't been initialized 
    public JLabel weatherfield;
    private JButton button1;

    public Display() {                   // you need constructor to call init
        init();
    }

    public void init() {
        myPanel = new JPanel(new BorderLayout());    // initialize
        weatherfield = new JLabel(" ");              // initialize
        button1 = new JButton("Button");              // initialize
        myPanel.add(weatherfield, BorderLayout.CENTER);
        myPanel.add(button1, BorderLayout.SOUTH);

        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                getandsetWeather();                       // <-------- add listener to call getandsetweather
            }
        });

        JFrame frame = new JFrame("Display");
        frame.setContentPane(myPanel);   //   <--------------------- fix 1
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(480, 234));
        frame.pack();
        frame.setVisible(true);
    }

    public void getandsetWeather() {
        String editedline = null;
        init();
        try {
            // Construct data
            String data = URLEncoder.encode("key1", "UTF-8") + "=" + URLEncoder.encode("value1", "UTF-8");
            data += "&" + URLEncoder.encode("key2", "UTF-8") + "=" + URLEncoder.encode("value2", "UTF-8");

            // Send data
            URL url = new URL("http://api.wunderground.com/api/772a9f2cf6a12db3/geolookup/conditions/q/UK/Chester.json");
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            // Get the response
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;
            while ((line = rd.readLine()) != null) {

                if( line.contains("\"weather\":")) {
                    System.out.println(line);
                    editedline = line.replace("\"weather\":\"", "");
                    editedline = editedline.replace("\",", "");
                    System.out.println(editedline);
                    weatherfield.setText(editedline);
                }


            }
            wr.close();
            rd.close();
            weatherfield.setText(editedline);
            System.out.println(weatherfield.getText());
            weatherfield.repaint();
            weatherfield.revalidate();
        } catch (Exception e) {
            System.out.println("Error!" + e);
        }


    }

}