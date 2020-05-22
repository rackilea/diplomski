public class SourceOneTransferOperation implements Transferable
{
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException
    {
        if (flavor.equals(FooDataFlavor.fooCopyButtonFlavor)) {
            TransferDataStrategy<Foo> tds = new FooCopyAAA(model);
            return tds;
        }
     ...
    }
}