public class JDialogSearch ... {
    public static final int OK_STATE = 0;
    public static final int CANCEL_STATE = 1;
    // Cause it's really nice to know what the use did
    // ie canceled, okay'ed, didn't find results, what ever...
    private int state = CANCEL_STATE;
    private String searchResult;

    //....///

    OK.addActionListener( new ActionListener() {

        private class OKListener implements ActionListener 
        {
            public void actionPerformed(ActionEvent e) {
                searchResult = someSearchField.getText(); // Or what ever you need
                state = OK_STATE;
                dispose(); // close window
            }
        }
    });

    //...//

    public int showSearchDialog() {
        // Other setup...
        setVisible(true);
        return state;
    }

    public String getSearchResult() {
        return searchResult;
    }