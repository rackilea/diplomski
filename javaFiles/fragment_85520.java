Widget thirdWidget = flexTable.getWidget(i, 2);

if (thirdWidget instanceof ListBox) {
  ListBox listBox = (ListBox) thirdWidget;
  ...

} else if (thirdWidget instanceof TextBox) {
  TextBox textBox = (TextBox) thirdWidget;
  ...
}