public void setupGUI ()
{
    // read the file and get the map
    Map<String, ArrayList<String>> sections = getSections();

    // get the authors
    ArrayList<String> authors = sections.get("AUTHOR");

    // Setup the jPanel2 by adding the SubPanels
    int num = authors.size();
    jButton1.addActionListener(new Clicker(num));
    jButton1.doClick();

    // Setup the JComboBox's by adding the data stored in the map
    for (int i = 0; i < authors.size(); i++)
    {
        int index = i;
        // not sure if getComponent() is zero or 1-baed so adjust the index accordingly.
        SubPanel panel = (SubPanel) jPanel2.getComponent(index);

        // Not sure if you already have the JComboBox in the SubPanel
        // If not, you can add them here.

        JComboBox jcb = panel.getJcb();
        jcb.setSelectedItem(authors.get(i));
    }
}