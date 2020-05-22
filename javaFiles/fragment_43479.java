import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class ButtonColours extends JFrame
{
    private static ButtonColours buttonColours;
    /*
     * Access Specifier is public, so that they can be 
     * accessed by the ColourDialog class.
     */ 
    public JButton[][] buttons;
    private static final int GRID_SIZE = 600;
    public static final int ROW = 6;
    public static final int COLUMN = 6;
    // Gap between each cell.
    private static final int GAP = 2;
    private static final Color DEFAULT_COLOUR = new Color(100,100,100);
    public static final String DEFAULT_COMMAND = "6";

    // Instance Variable for the ColourDialog class.
    private ColourDialog dialog = null;

    private BufferedReader input;
    private DataInputStream dataInputStream;
    private FileInputStream fileInputStream;
    private String line= "";

    /*
     * Event Handler for each JButton, inside
     * the buttons ARRAY.
     */
    public ActionListener buttonActions = new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            JButton button = (JButton) ae.getSource();
            System.out.println(ae.getActionCommand());
            if (dialog != null && dialog.isShowing())
                dialog.dispose();
            dialog = new ColourDialog(buttonColours, "COLOUR CHOOSER", false, button);      
            dialog.setVisible(true);
            button.setBackground(DEFAULT_COLOUR);
            button.setName("6");
        }
    };

    public ButtonColours()
    {
        buttons = new JButton[ROW][COLUMN];
        try
        {
            fileInputStream = new FileInputStream("start.txt");
            dataInputStream = new DataInputStream(fileInputStream);         
            input = new BufferedReader(new InputStreamReader(dataInputStream));
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    /*
     * Instead of explicitly calling getPreferredSize() method
     * we will override that method instead, for good
     * visual appearance fo the Program on different 
     * Platforms, i.e. Windows, MAC OS, LINUX
     */
    public Dimension getPreferredSize()
    {
        return (new Dimension(GRID_SIZE, GRID_SIZE));
    }

    private void readFile()
    {
        int rowNumber = -1;
        int columnNumber = -1;
        try
        {
            while((line = input.readLine()) != null)
            {
                String[] temp = line.split(" ");
                rowNumber = Integer.parseInt(temp[0].substring(1, temp[0].length()));
                columnNumber = Integer.parseInt(temp[1].substring(1, temp[1].length()));
                String colour = temp[2].trim();
                System.out.println("Row is : " + rowNumber);
                System.out.println("Column is : " + columnNumber);
                System.out.println("Colour is : " + colour);
                if (colour.equals("RED") && rowNumber < ROW && columnNumber < COLUMN)   
                {
                    System.out.println("I am working !");
                    buttons[rowNumber][columnNumber].setBackground(Color.RED);
                    buttons[rowNumber][columnNumber].setName("0");
                }
                else if (colour.equals("YELLOW") && rowNumber < ROW && columnNumber < COLUMN)
                {
                    buttons[rowNumber][columnNumber].setBackground(Color.YELLOW);
                    buttons[rowNumber][columnNumber].setName("1");
                }
                else if (colour.equals("BLUE") && rowNumber < ROW && columnNumber < COLUMN)
                {
                    buttons[rowNumber][columnNumber].setBackground(Color.BLUE);
                    buttons[rowNumber][columnNumber].setName("2");
                }
                else if (colour.equals("GREEN") && rowNumber < ROW && columnNumber < COLUMN)
                {
                    buttons[rowNumber][columnNumber].setBackground(Color.GREEN);
                    buttons[rowNumber][columnNumber].setName("3");
                }
                else if (colour.equals("PURPLE") && rowNumber < ROW && columnNumber < COLUMN)
                {
                    buttons[rowNumber][columnNumber].setBackground(new Color(102,0,102));
                    buttons[rowNumber][columnNumber].setName("4");
                }
                else if (colour.equals("BROWN") && rowNumber < ROW && columnNumber < COLUMN)
                {
                    buttons[rowNumber][columnNumber].setBackground(new Color(102,51,0));
                    buttons[rowNumber][columnNumber].setName("5");
                }
            }
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    private void createAndDisplayGUI()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        JComponent contentPane = (JComponent) getContentPane();
        contentPane.setLayout(new GridLayout(ROW, COLUMN, GAP, GAP));

        for (int i = 0; i < ROW; i++)
        {
            for (int j = 0; j < COLUMN; j++)
            {
                buttons[i][j] = new JButton();
                buttons[i][j].setOpaque(true);
                buttons[i][j].setBackground(DEFAULT_COLOUR);
                buttons[i][j].setActionCommand(i + " " + j);
                buttons[i][j].setName("6");
                buttons[i][j].addActionListener(buttonActions);
                contentPane.add(buttons[i][j]);
            }
        }
        pack();
        setVisible(true);
        readFile();
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                buttonColours = new ButtonColours();
                buttonColours.createAndDisplayGUI();
            }
        });
    }
}

class ColourDialog extends JDialog
{
    private Color[] colours = {
                                                Color.RED, 
                                                Color.YELLOW,
                                                Color.BLUE,
                                                Color.GREEN,
                                                new Color(102,0,102),
                                                new Color(102,51,0)
                                            };
    private int[] colourIndices = new int[6];
    private JButton redButton;
    private JButton yellowButton;
    private JButton blueButton;
    private JButton greenButton;
    private JButton purpleButton;
    private JButton brownButton;

    private JButton clickedButton;
    private int leftRowButtons;
    private int leftColumnButtons;

    public ColourDialog(final ButtonColours frame, String title, boolean isModal, JButton button)
    {
        super(frame, title, isModal);

        leftRowButtons = 0;
        leftColumnButtons = 0;

        clickedButton = button;

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        redButton = new JButton("RED");
        redButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String possibleColour = "0";
                /*
                 * Here we will check, if RED is clicked,
                 * do we have any block with the same colour
                 * or not, if yes then nothing will happen
                 * else we will change the background
                 * to RED.
                 */
                if (checkBlockColours(frame, possibleColour))
                {
                    clickedButton.setBackground(Color.RED);
                    clickedButton.setName("0");
                    dispose();
                    System.out.println("LEFT in ROW : " + leftRowButtons);
                    System.out.println("LEFT in COLUMN : " + leftColumnButtons);
                    System.out.println("Button Name : " + clickedButton.getName());
                    fillRemaining(frame);
                }
            }
        });
        yellowButton = new JButton("YELLOW");
        yellowButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String possibleColour = "1";
                if (checkBlockColours(frame, possibleColour))
                {
                    clickedButton.setBackground(Color.YELLOW);
                    clickedButton.setName("1");
                    dispose();
                    System.out.println("LEFT in ROW : " + leftRowButtons);
                    System.out.println("LEFT in COLUMN : " + leftColumnButtons);
                    System.out.println("Button Name : " + clickedButton.getName());
                    fillRemaining(frame);
                }
            }
        });
        blueButton = new JButton("BLUE");
        blueButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String possibleColour = "2";
                if (checkBlockColours(frame, possibleColour))
                {
                    clickedButton.setBackground(Color.BLUE);
                    clickedButton.setName("2");
                    dispose();
                    System.out.println("LEFT in ROW : " + leftRowButtons);
                    System.out.println("LEFT in COLUMN : " + leftColumnButtons);
                    System.out.println("Button Name : " + clickedButton.getName());
                    fillRemaining(frame);
                }
            }
        });
        greenButton = new JButton("GREEN");
        greenButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String possibleColour = "3";
                if (checkBlockColours(frame, possibleColour))
                {
                    clickedButton.setBackground(Color.GREEN);
                    clickedButton.setName("3");
                    dispose();
                    System.out.println("LEFT in ROW : " + leftRowButtons);
                    System.out.println("LEFT in COLUMN : " + leftColumnButtons);
                    System.out.println("Button Name : " + clickedButton.getName());
                    fillRemaining(frame);
                }
            }
        });
        purpleButton = new JButton("PURPLE");
        purpleButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String possibleColour = "4";
                if (checkBlockColours(frame, possibleColour))
                {
                    clickedButton.setBackground(new Color(102,0,102));
                    clickedButton.setName("4");
                    dispose();
                    System.out.println("LEFT in ROW : " + leftRowButtons);
                    System.out.println("LEFT in COLUMN : " + leftColumnButtons);
                    System.out.println("Button Name : " + clickedButton.getName());
                    fillRemaining(frame);
                }
            }
        });
        brownButton = new JButton("BROWN");
        brownButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String possibleColour = "5";
                if (checkBlockColours(frame, possibleColour))
                {
                    clickedButton.setBackground(new Color(102,51,0));
                    clickedButton.setName("5");
                    dispose();
                    System.out.println("LEFT in ROW : " + leftRowButtons);
                    System.out.println("LEFT in COLUMN : " + leftColumnButtons);
                    System.out.println("Button Name : " + clickedButton.getName());
                    fillRemaining(frame);
                }
            }
        });

        panel.add(redButton);
        panel.add(yellowButton);
        panel.add(blueButton);
        panel.add(greenButton);
        panel.add(purpleButton);
        panel.add(brownButton);

        add(panel);

        pack();
    }

    private boolean checkBlockColours(ButtonColours frame, String possibleColour)
    {
        leftRowButtons = 0;
        leftColumnButtons = 0;
        String command = clickedButton.getActionCommand();
        String[] array = command.split(" ");
        int row = Integer.parseInt(array[0]);
        int column = Integer.parseInt(array[1]);        
        // First we will check in ROW. for the same colour, that is clicked.
        for (int i = 0; i  < ButtonColours.COLUMN; i++)
        {
            if (i != column)
            {
                JButton button = frame.buttons[row][i];
                if (button.getName().equals(possibleColour))
                    return false;
                else if (button.getName().equals(ButtonColours.DEFAULT_COMMAND))    
                    leftRowButtons++;
            }   
        }
        // Now we will check in COLUMN, for the same colour, that is clicked.
        for (int i = 0; i  < ButtonColours.ROW; i++)
        {
            if (i != row)
            {
                JButton button = frame.buttons[i][column];
                if (button.getName().equals(possibleColour))
                    return false;
                else if     (button.getName().equals(ButtonColours.DEFAULT_COMMAND))    
                    leftColumnButtons++;
            }   
        }
        return true;
    }

    private void fillRemaining(ButtonColours frame)
    {
        String command = clickedButton.getActionCommand();
        String[] array = command.split(" ");
        int row = Integer.parseInt(array[0]);
        int column = Integer.parseInt(array[1]);    
        int emptyRow = -1;
        int emptyColumn = -1;
        if (leftRowButtons == 1)
        {
            for (int i = 0; i  < ButtonColours.COLUMN; i++)
            {
                JButton button = frame.buttons[row][i];
                int colourIndex = Integer.parseInt(button.getName()); 
                switch(colourIndex)
                {
                    case 0:
                        colourIndices[0] = 1;
                        break;
                    case 1:
                        colourIndices[1] = 1;
                        break;
                    case 2:
                        colourIndices[2] = 1;
                        break;
                    case 3:
                        colourIndices[3] = 1;
                        break;
                    case 4:
                        colourIndices[4] = 1;
                        break;
                    case 5:
                        colourIndices[5] = 1;
                        break;
                    default:
                        emptyRow = row;
                        emptyColumn = i;
                }               
            }
            for (int i = 0; i < colourIndices.length; i++)
            {
                if (colourIndices[i] == 0)
                {
                    frame.buttons[emptyRow][emptyColumn].setBackground(colours[i]);
                    setButtonName(frame.buttons[emptyRow][emptyColumn], i);
                    System.out.println("Automatic Button Name : " + frame.buttons[emptyRow][emptyColumn].getName());
                    System.out.println("Automatic Row : " + emptyRow);
                    System.out.println("Automatic Column : " + emptyColumn);
                    disableListenersRow(frame, row);
                    if (checkBlockColours(frame, ButtonColours.DEFAULT_COMMAND))
                    {
                        System.out.println("LEFT in ROW : " + leftRowButtons);
                        System.out.println("LEFT in COLUMN : " + leftColumnButtons);
                        System.out.println("Button Name : " + clickedButton.getName());
                        fillRemaining(frame);
                    }
                    break;
                }
            }
        }
        if (leftColumnButtons == 1)
        {
            for (int i = 0; i  < ButtonColours.ROW; i++)
            {
                JButton button = frame.buttons[i][column];
                int colourIndex = Integer.parseInt(button.getName()); 
                switch(colourIndex)
                {
                    case 0:
                        colourIndices[0] = 1;
                        break;
                    case 1:
                        colourIndices[1] = 1;
                        break;
                    case 2:
                        colourIndices[2] = 1;
                        break;
                    case 3:
                        colourIndices[3] = 1;
                        break;
                    case 4:
                        colourIndices[4] = 1;
                        break;
                    case 5:
                        colourIndices[5] = 1;
                        break;
                    default:
                        emptyRow = i;
                        emptyColumn = column;
                }               
            }
            for (int i = 0; i < colourIndices.length; i++)
            {
                if (colourIndices[i] == 0)
                {
                    frame.buttons[emptyRow][emptyColumn].setBackground(colours[i]);
                    setButtonName(frame.buttons[emptyRow][emptyColumn], i);
                    System.out.println("Automatic Button Name : " + frame.buttons[emptyRow][emptyColumn].getName());
                    System.out.println("Automatic Row : " + emptyRow);
                    System.out.println("Automatic Column : " + emptyColumn);
                    disableListenersColumn(frame, column);
                    if (checkBlockColours(frame, ButtonColours.DEFAULT_COMMAND))
                    {
                        System.out.println("LEFT in ROW : " + leftRowButtons);
                        System.out.println("LEFT in COLUMN : " + leftColumnButtons);
                        System.out.println("Button Name : " + clickedButton.getName());
                        fillRemaining(frame);
                    }
                    break;
                }
            }
        }
    }

    private void setButtonName(JButton button, int index)
    {
        switch(index)
        {
            case 0:
                button.setName("0");
                break;
            case 1:
                button.setName("1");
                break;
            case 2:     
                button.setName("2");
                break;
            case 3:
                button.setName("3");
                break;
            case 4:
                button.setName("4");
                break;
            case 5:
                button.setName("5");
                break;
        }       
    }

    private void disableListenersRow(ButtonColours frame, int row)
    {
        System.out.println("Disabled ROW : " + row);        
        for (int i = 0; i < ButtonColours.ROW; i++)
        {
            frame.buttons[row][i].removeActionListener(frame.buttonActions);
            System.out.println("DISABLED BUTTONS : " + row + " " + i);
        }           
    }

    private void disableListenersColumn(ButtonColours frame, int column)
    {
        System.out.println("Disabled COLUMN : " + column);
        for (int i = 0; i < ButtonColours.COLUMN; i++)
        {
            frame.buttons[i][column].removeActionListener(frame.buttonActions);
            System.out.println("DISABLED BUTTONS : " + i + " " + column);
        }
    }
}