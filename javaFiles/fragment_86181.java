// read two files, append them and print result to stdout
  else if ((args.length == 3) && (args[0].toLowerCase().equals("append"))) {
DataSource source1 = new DataSource(args[1]);
DataSource source2 = new DataSource(args[2]);
String msg = source1.getStructure().equalHeadersMsg(source2.getStructure());
if (msg != null)
  throw new Exception("The two datasets have different headers:\n" + msg);
Instances structure = source1.getStructure();
System.out.println(source1.getStructure());
while (source1.hasMoreElements(structure))
  System.out.println(source1.nextElement(structure));
structure = source2.getStructure();
while (source2.hasMoreElements(structure))
  System.out.println(source2.nextElement(structure));
  }