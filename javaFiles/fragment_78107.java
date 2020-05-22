Private OnClickListener listener = new OnClickListener()
{
    public void onClick(View v)
    {
         int buttonValue = (int)v.getTag();
         total += buttonValue;
         myTextView.setText(String.valueOf(total));
    }
}