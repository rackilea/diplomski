private static ArrayList<String> ListValues;
private static List<String> LogValues = new ArrayList<String>();
private Integer BaseValue;

public customAdapter(Context context, ArrayList<String> listValues, int baseValue) {
super(context, R.layout.infiniteloglayout, listValues);
this.ListValues = listValues;
for (int i = 0; i < listValues.size(); i++) {
    LogValues.add(Double.toString(Math.log(Double.parseDouble(listValues[i])) / Math.log(baseValue)));
}
BaseValue = baseValue;
}