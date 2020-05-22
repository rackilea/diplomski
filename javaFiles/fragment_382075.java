List<Pojo> pojos = new ArrayList<>(25);
pojos.add(new Pojo("one", "two", "three", "four", "five"));

PojoTransferable pt = new PojoTransferable(pojos);
Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
cb.setContents(pt, new ClipboardOwner() {
    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        System.out.println("Lost");
    }
});
try {
    Object data = cb.getData(PojoTransferable.POJO_LIST_DATA_FLAVOR);
    if (data instanceof List) {
        List listOfPojos = (List)data;
        System.out.println("listOfPojos contains " + listOfPojos.size());
        for (Object o : listOfPojos) {
            System.out.println(o);
        }
    }
} catch (UnsupportedFlavorException ex) {
    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
} catch (IOException ex) {
    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
}