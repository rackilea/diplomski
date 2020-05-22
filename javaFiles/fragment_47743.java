List<Integer> values = new ArrayList<Integer>();
for (int i = 0; i < myresult.length; i++)
    values.add(myresult[i]);

Collections.shuffle(values);

tvanswer1.setText(values.get(0).toString());
tvanswer2.setText(values.get(1).toString());
...