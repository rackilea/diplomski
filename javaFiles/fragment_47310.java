InputStream middle ;
String beginning = "Once upon a time ...\n";
String end = "\n... and they lived happily ever after.";
List<InputStream> streams = Arrays.asList(
    new ByteArrayInputStream(beginning.getBytes()),
    middle,
    new ByteArrayInputStream(end.getBytes()));
InputStream story = new SequenceInputStream(Collections.enumeration(streams));