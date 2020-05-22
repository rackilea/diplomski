private TreeMap<String, String> buttonColors;

// Constructor
public FP() {

    super("ColorMap");
    buttonColors = new TreeMap<String, String>();

    BufferedReader br = new BufferedReader(new FileReader("InputFile.txt");
    while(true)
    {
      String str = br.readLine();
      if(str==null)break;
      if(str.length()==0)continue;
      string[] st = str.split(" ");
      string colorName = st[0].trim();
      string colorValue = st[1].trim();

      //* to have the colors sorted by the hex value
      buttonColors.put(colorValue, colorName);
    }
    br.close();

    //test button
    //buttonColors.put("Red", "FF0000");

    setSize(400, 400);
    setLayout(new FlowLayout());
    ButtonGroup buttonGroup = new ButtonGroup();

    for (Map.Entry<String, String> coloringButtons : buttonColors
            .entrySet()) {

        JRadioButton button = new JRadioButton(coloringButtons.getValue());

        button.setActionCommand(coloringButtons.getKey());
        button.addActionListener(this);

        // Add this new color-button to the button group
        buttonGroup.add(button);
        add(button);
    }
}