@SuppressWarnings("unchecked")
public static Enumeration<InputStream> split(final SequenceInputStream sis){
    try{
        Field streamsEnumField =
            SequenceInputStream.class.getDeclaredField("e");
        streamsEnumField.setAccessible(true);
        return (Enumeration<InputStream>) streamsEnumField.get(sis);
    } catch(final Exception e){
        throw new IllegalStateException(e);
    }
}