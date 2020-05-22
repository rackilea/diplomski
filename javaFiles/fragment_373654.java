private static void serializeData(Object diagData) throws Exception {
    XStream xstream = new XStream();
    xstream.processAnnotations(DiagData.class);

    FileOutputStream fileOutputStream = null;
    Writer writer = new PrintWriter(new File(your file));
    CompactWriter compactWriter = new CompactWriter(writer);

    try {
        writer.write(your xml prolog);
        writer.write(your stylesheet);
        xstream.marshal(diagData, compactWriter);
    } catch (FileNotFoundException e1) {

    } catch (Exception e) {

    } finally {
       release resources
   }
}