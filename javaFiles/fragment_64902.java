void patchAdvanceWidth(InputStream is, OutputStream os, int entry, int newValue) throws IOException
{
    FontFactory fontFactory = FontFactory.getInstance();
    Builder[] builders = fontFactory.loadFontsForBuilding(is);
    Builder builder = builders[0];

    HorizontalMetricsTable.Builder hmtxBuilder = (HorizontalMetricsTable.Builder) builder.getTableBuilder(Tag.hmtx);
    WritableFontData hmtxData = hmtxBuilder.data();

    int offset = 0 + (entry * 4) + 0;
    hmtxData.writeUShort(offset, newValue);
    hmtxBuilder.setData(hmtxData);

    Font font = builder.build();
    fontFactory.serializeFont(font, os);
}