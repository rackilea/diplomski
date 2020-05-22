public MultiButton retrieveListItem(String content, ActionListener l) {
    ParseObject po = null;
    try {

        po = ParseObject.fetch(content /*class name*/, "nsC2NdmCuQ" /*objectId*/);

    } catch (ParseException e) {

        Dialog.show("Err", "Oops! Database is not available at the moment" + e.getCode(), "OK", null);
    }

    MultiButton title = new MultiButton("Book's Title: " + po.getString("Title"));
    title.addActionListener(l);
    title.putClientProperty("ParseObject", po);
    return title;
}