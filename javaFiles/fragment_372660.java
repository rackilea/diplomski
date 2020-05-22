public class IntegerList extends ArrayList<Integer> {
}

for (Type actualTypeArgument : getTypes(new IntegerList())) {
  System.out.println(actualTypeArgument);
}