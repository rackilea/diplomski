FileInputStream fi1 = new FileInputStream("resources/test-1.text");
FileInputStream fi2 = new FileInputStream("resources/test-2.text");

String newLine = "\n";
List<InputStream> streams = Arrays.asList(
    fi1,
    new ByteArrayInputStream(newLine.getBytes()),
    fi2);
InputStream seq = new SequenceInputStream(Collections.enumeration(streams));

int i= 0;

while((i = seq.read())!=-1)
    System.out.print((char)i);