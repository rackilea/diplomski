package cornerlink;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class CornerLink {
    private static JFrame frame = new JFrame(); // globalize the button window Component
    private static JLabel label = new JLabel(); // globalize the JLabel component holding the button image.
    private static int keysValue = 0;   // Use for determining if the CTRL-ALT-C buttons are depressed.
    private static int xLoc = 0;    // Used for optionally supplying a X axis location for the button.
    private static int yLoc = 0;    // Used for optionally supplying a Y axis location for the button.

    // Command Line Options (in the same order)...
    private static String buttonImage = "";              // Mandatory
    private static String webLink = "";        // Mandatory
    private static Dimension buttonSize = new Dimension(110,110);   // Optional
    private static Dimension buttonLocation = new Dimension(0,0);   // Optional
    private static Color borderColor = Color.BLACK;                 // Optional
    private static int borderThickness = 1;                         // Optional
    private static float buttonOpacity = 1.0f;                      // Optional
    private static boolean closeOnCtrlAltCClick = true;             // Optional
    private static boolean allowMouseMove = false;                  // Optional



    public static void main(String[] args) {
        // Get and process the commandline arguments.
        processCommandLineArguments(args);
        // Build our button
        setupGUI();
        // Set mouse and keyboard listeners for gathering key
        // combinations for closing, button movement, and mouse
        // click for going to the web link supplied within the 
        //commandline.
        setupAdapters();
    }

    private static void processCommandLineArguments(String[] args) {
        try{
            // Close if no Command Line Arguments are supplied. Must have at least
            // 2 arguments, the Image Path and a Web Link. Others are optional.
            if (args.length == 0) { System.exit(0); }
            // The Image to display within button
            if (args.length >= 1 && !args[0].equals("")) { buttonImage = args[0]; }
            else { System.exit(0); }
            // The web link to go to when image is clicked upon
            if (args.length >= 2 && !args[1].equals("")) { webLink = args[1]; }
            else { System.exit(0); }
            // Button Size
            if (args.length >= 3 && !args[2].equals("")) { 
                String[] bd = args[2].split(","); 
                buttonSize = new Dimension(Integer.valueOf(bd[0]), Integer.valueOf(bd[1]));
            }
            // Button Location
            if (args.length >= 4 && !args[3].equals("")) { 
                String[] bl = args[3].split(","); 
                buttonLocation = new Dimension(Integer.valueOf(bl[0]), Integer.valueOf(bl[1]));
            }
            // The Border Color - Must be in Hex String format including Hash Mark (ie: "#FFCCFF").
            // If the Hash mark is forgoten then it is automatically placed onto the Hex String.
            if (args.length >= 5 && !args[4].equals("")) { 
                if (!args[4].substring(0, 1).equals("#")) { args[4] = "#" + args[4]; }
                borderColor = Color.decode(args[4]); 
            }
            // The Border Thickness
            if (args.length >= 6 && !args[5].equals("")) { borderThickness = Integer.valueOf(args[5]); }
            // The Button Opacity
            if (args.length >= 7 && !args[6].equals("")) { 
                args[6] = args[6].replace("f", "");
                buttonOpacity = Float.valueOf(args[6]); 
            }
            // Allow the CTRL-ALT-C - Left Mouse Click sequence to close the button
            if (args.length >= 8 && !args[7].equals("")) { closeOnCtrlAltCClick = args[7].equalsIgnoreCase("true"); }
            // Allow the button to be dragged around the screen with mouse.
            if (args.length >= 9 && !args[8].equals("")) { allowMouseMove = args[8].equalsIgnoreCase("true"); }
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog (null, "Error Detected While Processing Command-Line!\n"
                    + "Check Command-Line Parameters For Proper Format.\n\n" + ex.getMessage(), 
                    "Command-Line Error", JOptionPane.ERROR_MESSAGE); 
        }
    }

    private static void setupGUI(){
        // Get the working screen size. The dimensions retrieved here will
        // be used to position our button on the top right corner of our
        // working screen (by default) unless a button location is supplied
        // within the commandline. 
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Establish a JPanel and set the layout manager. Our JLabel will be 
        // placed on this panel and will be automatically exploded to the same
        // size.
        JPanel panel = new JPanel(new BorderLayout());


        // Gather the supplied image determined from commandline, set it into
        // the JLabel but resize the image to fit in JLabel first.
        ImageIcon image;
        try {
            // Is it a Web URL to the desired Image...
            if (buttonImage.startsWith("http")){
                URL img = new URL(buttonImage);  
                image = new ImageIcon(img);
            }
            // If not then it must be from the local file system.
            else { 
                image = new ImageIcon(buttonImage);
            }
            label.setIcon(resizeIcon(image, (buttonSize.width - borderThickness), (buttonSize.height - borderThickness)));
        }
        catch (MalformedURLException ex) {
            // Get outta here if a bogus URL was provided.
            JOptionPane.showMessageDialog (null, "Improper Image URL provided!",
                                         "URL Error",JOptionPane.ERROR_MESSAGE); 
            System.exit(0);
        }
        // Add the JLabel to our JPanel.
        panel.add(label);
        // Add the JPanel to our JFrame.
        frame.add(panel);
        // Set the size of our button (JFrame). Everything else will adjust
        // in size to accomodate.
    frame.setSize(buttonSize.width, buttonSize.height);

        // Set the button location on screen. If button location dimensions
        // we supplied in commandline then use that location otherwise use 
        // the default location (top-right).
        if (buttonLocation.width == 0 && buttonLocation.height == 0) {
            frame.setLocation((screenSize.width - frame.getWidth())-25, 25);
        }
        else {
            frame.setLocation(buttonLocation.width, buttonLocation.height);
        }
        // Set the JFrame type to be UTILITY so that a Icon does
        // not display within the Task Bar.
        frame.setType(javax.swing.JFrame.Type.UTILITY);
        // Set the JFrame type to NOT have a Title Bar
        frame.setUndecorated(true);
        // Set the button's opacity
        frame.setOpacity(buttonOpacity);
        // Set the Border for our Button
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(borderThickness, 
                     borderThickness, borderThickness, borderThickness, borderColor));
        // Exit the application of frame close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Make sure our button is always on top of everything else.
        frame.setAlwaysOnTop(true);
        // Display the button on screen...
        frame.setVisible(true);
        frame.validate();
    }

    private static void setupAdapters(){
        // Open a Key Listener to detect key presses for
        // closing the button window.
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                // Detect the CTRL-ALT-C keypress combination...
                if ((evt.getKeyCode() == KeyEvent.VK_C) && ((evt.getModifiers() & KeyEvent.CTRL_MASK) != 0) && 
                        ((evt.getModifiers() & KeyEvent.ALT_MASK) != 0)) {
                    keysValue = 1000;
                }
                else { keysValue = 0; }
            }
        });

        // Open a Mouse Listener to detect a mouse button click
        // on the displayed image so as to fire the supplied link
        // or to close the button window if the proper key press
        // sequence is established for closing.
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) { 
                if (keysValue == 1000 && closeOnCtrlAltCClick == true && evt.getButton() == 1) { System.exit(0); }
                if (!webLink.equals("") && evt.getButton() == 1) { gotoUrl(webLink, true, true); }
            }
            @Override
            public void mousePressed(MouseEvent evt) {
                xLoc = evt.getX();
                yLoc = evt.getY();
            }
        });

        // Open a Mouse Motion Listener to detect a mouse Drag 
        // on the displayed image so as to Move the image button.
        label.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent evt) {}

            @Override
            public void mouseDragged(MouseEvent evt) { 
                if (allowMouseMove) {
                    frame.setLocation(evt.getXOnScreen() - xLoc, evt.getYOnScreen() - yLoc);
                }
            }
        });

    }

    // Use to resize the supplied ImageIcon to desired width and height.
    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();  
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
        return new ImageIcon(resizedImage);
    }

    /**
     * This method will check to see if there is Internet access on for the work station
     * (computer) that initiated the call. 
     * @param urlPath Optional - http:// String - Default is: "http://www.google.com" - 
     * You can supply your own test URL but always use a test URL that you know will be continuously 
     * active and reliable. You can however also use the URL to your own Website to ensure it is active.<br>
     * @return Boolean true if connection can be established to the test URL and boolean 
     * false if it can not.
     */
    public static boolean isThereInternet(String... urlPath) {
        String urlp = "http://www.google.com";
        if (urlPath.length != 0) { if (urlPath[0].length() != 0) { urlp = urlPath[0]; } }
        if (!doesUrlExist(urlp, false)) { return false; }

        try {
            final URL url = new URL(urlp);
            final URLConnection conn = url.openConnection();
            conn.connect();
            return true;
        } 
        catch (MalformedURLException e) { return false; }
        catch (IOException e) { return false; }                                                                                                                                                                                                                                     

    }

    /**
     * Opens the default web browser in any platform then goes to and displays the provided URL.
     * If it is found that the supplied URL does not exist then a warning message is optionally 
     * displayed and the attempt to go to the provided URL is aborted.
     * @param urlToGoTo The URL (internet address) to go to.<br>
     * @param options Two Optional Parameters - Both are default true. Parameters are in the following order:<pre>
     * 
     *         <b><i>checkForInternet</i></b>    - Default true. Checks to make sure an Internet Connection
     *                               is available. If it is not then a Message is optionally 
     *                               displayed (see displayMessages parameter).
     * 
     *         <b><i>displayMessages</i></b>     - Default true. If true will force this method to display
     *                               warning messages with regards to No Internet Connection
     *                               or URL Not Found or Network Error Codes. If false no
     *                               messages are displayed.</pre>
     */
    public static void gotoUrl(String urlToGoTo, boolean... options) {
        boolean checkNet = true;
        boolean doMsgs = true;
        String errMsg = "";

        if (options.length != 0) {
            checkNet = options[0];
            if (options.length == 2) { doMsgs = options[1]; }
        }
        if (checkNet) {
            if (!isThereInternet()) {
                if (doMsgs) {
                    JOptionPane.showMessageDialog (null, "No Internet Connection Detected! Check Your Network Connections.",
                       "GotoUrl() - No Internet Connection",JOptionPane.WARNING_MESSAGE); 
                }
                return;
            }
        }

        if (!doesUrlExist(urlToGoTo, doMsgs)) { 
            if (doMsgs) {
                JOptionPane.showMessageDialog (null,"The Supplied URL Does Not Exist In Network!\n\n" + urlToGoTo,
                       "GotoUrl() - Address Not Found",JOptionPane.WARNING_MESSAGE); 
            }    
            return; 
        }

        if(Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(urlToGoTo));
            } 
            catch (IOException | URISyntaxException e) { errMsg = e.getMessage(); }
        }
        else {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + urlToGoTo);
            }
            catch (IOException e) { errMsg = e.getMessage(); }
        }

        if (doMsgs && !"".equals(errMsg)) {
            JOptionPane.showMessageDialog (null, "Error encountered while trying to display the supplied\n"
                 + "URL in default Web Browser.\n\n"+ errMsg,
                   "GotoUrl() - Error Encountered",JOptionPane.WARNING_MESSAGE); 
        }
    }

    /**
     * Test to see if the supplied network URL actually exists on the network (Internet),
     * for example:<pre>
     * 
     *      Debug(DoesURLExist("http://www.google.trg"));    // displays false in Output.
     *      Debug(DoesURLExist("http://www.google.com"));    // displays true in Output.</pre><br>
     * 
     * This method can also check to see if the URL to a specific file is valid or not, like perhaps
     * the image on a web page or a file repository of sorts. Here is an example:<pre>
     * 
     *      Debug(DoesURLExist("http://www.picswalls.com/images/logo.png"));</pre><br>
     * 
     * If the URL exists then boolean true is returned but if the URL doesn't exist then boolean 
     * false is returned. If the URL exists but there was an error loading the web page then a 
     * Response Code is issued by the web server and is detected by this method which in turn then
     * forces a boolean false to be returned. A message is displayed indicating the error unless boolean 
     * false was supplied to the optional <font color=green><b>showResponseError</b></font> parameter.
     * @param urlString The http:// or https:// URL to check.<br>
     * @param showResponseError Optional - Boolean true or false - Default is <font color=blue><b>true</b></font> - 
     * Turns the Response Code Error display On or Off. True is ON and false is OFF.<br>
     * @return
     */
    public static boolean doesUrlExist(String urlString, boolean... showResponseError) {
        if (urlString.equals("") || !urlString.matches("((http)[s]?(://).*)")) { return false; }

        boolean showResponse = true;
        if (showResponseError.length != 0) { showResponse = showResponseError[0]; }

        try {
            final URL url = new URL(urlString);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            int responseCode = huc.getResponseCode();
            huc.disconnect();
            //Does responseCode not equal 200 (which is the code for: OK)...
            if (responseCode != HttpURLConnection.HTTP_OK) {
                if (showResponse) {
                    String msg = getResponseCodeString(responseCode);
                    msg = "There was a problem connecting to:\n\n" + urlString + "\n\n" +
                          "Response Code: [" + responseCode + "] - " + msg;  
                    JOptionPane.showMessageDialog (null, msg, "Network Connection Error",JOptionPane.WARNING_MESSAGE);
                }
                return false;       
            }
            return true;
        } 
        catch (UnknownHostException | FileNotFoundException ex) { }
        catch (IOException | HeadlessException e) { }
        return false;
    }

    /**
     * Response Codes are code numbers issued by a network server when connecting to an URL. This
     * method will return the string description of the response code number supplied. This is 
     * handy if you want to connect to an Network URL but can and you want to find out why. 
     * @param codeNum The integer response code number received from server.<br>
     * @return The string description for the response code number supplied.
     */
    public static String getResponseCodeString(int codeNum) {
        String strg;
        switch (codeNum) {
            case 100:
                strg = "Informational - Continue";
                break;
            case 101:
                strg = "Informational - Switching Protocols";
                break;
            case 200:
                strg = "Success - OK";
                break;
            case 201:
                strg = "Success - Created";
                break;
            case 202:
                strg = "Success - Accepted";
                break;
            case 203:
                strg = "Success - Non-Authoritative Information";
                break;
            case 204:
                strg = "Success - No Content";
                break;
            case 205:
                strg = "Success - Reset Content";
                break;
            case 206:
                strg = "Success - Partial Content";
                break;
            case 300:
                strg = "Redirection - Multiple Choices";
                break;
            case 301:
                strg = "Redirection - Moved Permanently";
                break;                
            case 302:
                strg = "Redirection - Found";
                break;
            case 303:
                strg = "Redirection - See Other";
                break;
            case 304:
                strg = "Redirection - Not Modified";
                break;
            case 305:
                strg = "Redirection - Use Proxy";
                break;
            case 306:
                strg = "Redirection - (Unused)";
                break;
            case 307:
                strg = "Redirection - Temporary Redirect";
                break;
            case 400:
                strg = "Client Error - Bad Request";
                break;
            case 401:
                strg = "Client Error - Unauthorized";
                break;
            case 402:
                strg = "Client Error - Payment Required";
                break;
            case 403:
                strg = "Client Error - Forbidden";
                break;
            case 404:
                strg = "Client Error - Not Found";
                break;
            case 405:
                strg = "Client Error - Method Not Allowed";
                break;
            case 406:
                strg = "Client Error - Not Acceptable";
                break;
            case 407:
                strg = "Client Error - Proxy Authentication Required";
                break;
            case 408:
                strg = "Client Error - Request Timeout";
                break;
            case 409:
                strg = "Client Error - Conflict";
                break;
            case 410:
                strg = "Client Error - Gone";
                break;
            case 411:
                strg = "Client Error - Length Required";
                break;
            case 412:
                strg = "Client Error - Precondition Failed";
                break;
            case 413:
                strg = "Client Error - Request Entity Too Large";
                break;
            case 414:
                strg = "Client Error - Request-URI Too Long";
                break;
            case 415:
                strg = "Client Error - Unsupported Media Type";
                break;
            case 416:
                strg = "Client Error - Request Range Not Satisfiable";
                break;
            case 417:
                strg = "Client Error - Expectation Failed";
                break;
            case 500:
                strg = "Server Error - Internal Server Error";
                break;
            case 501:
                strg = "Server Error - Not Implemented";
                break;
            case 502:
                strg = "Server Error - Bad Gateway";
                break;
            case 503:
                strg = "Server Error - Service Unavailable";
                break;
            case 504:
                strg = "Server Error - Gateway Timeout";
                break;
            case 505:
                strg = "Server Error - HTTP Version Not Supported";
                break;                
            default:
                strg = "Unknown Response";
        }
        return strg;
    }


}