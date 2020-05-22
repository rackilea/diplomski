List<String> listItems = new ArrayList<String>();

listItems.add("Item1");
listItems.add("Item2");
listItems.add("Item3");

final CharSequence[] charSequenceItems = listItems.toArray(new CharSequence[listItems.size()]);