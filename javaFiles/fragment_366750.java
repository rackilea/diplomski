Object[] objArray = (Object[]) getIntent().getExtras().getSerializable("blah");

List<?> objList = Arrays.asList(objArray);

ArrayList<int[]>[] arrayOfLists = new ArrayList[objList.size()];

arrayOfLists = objList.toArray(arrayOfLists);
// example value extraction
int[] values1 = arrayOfLists[0].get(0);