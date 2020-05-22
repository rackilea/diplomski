static JList lengthList;
    static JList colorList;
    static JScrollPane lengthScrollPane;
    static JScrollPane colorScrollPane;
    static JPanel hairPanel = new JPanel();
    static JLabel selectedColor = new JLabel();
    static JLabel selectedLength = new JLabel();

    public static void main(String[] args) {
        JFrame window = new JFrame();
        //Hair Options for both size and color displayed in a window
        window.setSize(400,400);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.setTitle("Hair Options");
        window.setLayout(new BorderLayout());
        window.setAlwaysOnTop(true);

        buildHairPanel();
        window.add(hairPanel);

        window.setVisible(true);
    }


    private static void buildHairPanel()
    {
        //Build Hair Color Selection
        String[] hairColors = new String[] { "brown", "blonde", "black", "red", "green", "blue" };
        colorList = new JList(hairColors);
        colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        colorList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e)
            {
                String selection = (String) optionsSelect.colorList.getSelectedValue();
                optionsSelect.selectedColor.setText(selection);
            }
        });

        colorList.setVisibleRowCount(3);
        colorScrollPane = new JScrollPane(colorList);
        hairPanel.add(colorScrollPane);

        //Build Hair Length Selection
        String[] hairLengths = new String[] { "short1", "short2", "medium1", "medium2", "long1", "long2" };
        lengthList = new JList(hairLengths);
        lengthList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        lengthList.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e)
            {
                String selection = (String) optionsSelect.lengthList.getSelectedValue();
                optionsSelect.selectedLength.setText(selection);
            }
        });

        lengthList.setVisibleRowCount(3);
        lengthScrollPane = new JScrollPane(lengthList);
        hairPanel.add(lengthScrollPane);
    }