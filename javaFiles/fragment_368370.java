public class Board extends JPanel {

    // array of sections
    private BoardSection[] sections;

    // Board Constructor
    public Board() {

        //...//

        // add board sections to board
        sections = new BoardSection[9];
        for (int i = 0; i < sections.length; i++) {
            sections[i] = new BoardSection();
            add(sections[i]);
        }

    }

    // fill the board with data
    public void fill(int[][] data) {

        // create data sections
        String[][] nwData = new String[3][3];
        String[][] nData = new String[3][3];
        String[][] neData = new String[3][3];
        String[][] wData = new String[3][3];
        String[][] cData = new String[3][3];
        String[][] eData = new String[3][3];
        String[][] swData = new String[3][3];
        String[][] sData = new String[3][3];
        String[][] seData = new String[3][3];

        // break data into data sections
        nwData = createSection(data, 0, 0);
        nData = createSection(data, 3, 0);
        neData = createSection(data, 6, 0);
        wData = createSection(data, 0, 3);
        cData = createSection(data, 3, 3);
        eData = createSection(data, 6, 3);
        swData = createSection(data, 0, 6);
        sData = createSection(data, 3, 6);
        seData = createSection(data, 6, 6);

        // fill board section with data section
        sections[0].fillSection(nwData);
        sections[1].fillSection(nData);
        sections[2].fillSection(neData);
        sections[3].fillSection(wData);
        sections[4].fillSection(cData);
        sections[5].fillSection(eData);
        sections[6].fillSection(swData);
        sections[7].fillSection(sData);
        sections[8].fillSection(seData);

    }