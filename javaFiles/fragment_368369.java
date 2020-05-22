// Board Constructor
public Board() {

    //...//

    // add board sections to board
    for (int i = 0; i < sections.length; i++) {
        // Look ma, new Board!!
        sections[i] = new BoardSection();
        add(sections[i]);
    }

}