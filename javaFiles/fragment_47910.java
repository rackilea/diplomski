@Override
public void onBindViewHolder(ExampleViewHolder holder, int position) {
    CustomClass object = mCustomObjects.get(position);

    String firstText = object.getFirstText()
    String secondText = object.getSecondText()

    holder.text1.setText(firstText);
    holder.text2.setText(secondText);
}