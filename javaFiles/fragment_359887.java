String st;
List<Float> valueList = new ArrayList<>(); 
while ((st = br.readLine()) != null) {         
   valueList.add(Float.parseFloat(st.trim()));
}
Float[] values = new Float[valueList.size()];
values = valueList.toArray(values);