public static void ListPants(ArrayList<Pants> selection, Pants.SizeType size)
{
for (Pants.SizeType sizeType : Pants.SizeType.values()) {
    for (Pants pants : selection) {
        if (pants.getSize().equals(sizeType)) {
           System.out.println(selection.toString());