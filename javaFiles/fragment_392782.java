Checkbox c;

public buyU (CheckBox checkbox)
{
  c = checkbox;
}

@Override
protected void onPostExecute (Result result)
{
  c.setChecked (false);
  c.setEnabled (false);
}