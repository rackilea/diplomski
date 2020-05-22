for (Map.Entry<String, JButton> entry : listbouton.entrySet())
{
  String key = entry.getKey();
  JButton value = entry.getValue();

  this.add(value);
}