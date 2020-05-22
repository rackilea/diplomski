class Class1 
{
      JTextField field1;
      public String getFieldText()
      {
            return field1.getText();
      }
}
class Class2
{
      JTextField field2;
      Class2(Class1 c1)
      {
            field2.setText(c1.getFieldText());
      }
}