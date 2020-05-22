RichTextItem rti = null;
Item item = doc.getFirstItem("somefield");
if (item != null) {
    if (item instanceof RichTextItem) {
        //Yay!
        rti = (RichTextItem) item;
    } else {
        //:-(
    }
} else {
        rti = doc.createRichTextItem("somefield");
        //etc.
}