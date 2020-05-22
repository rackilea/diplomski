OnClickListener onTabButtonClickListener = new OnClickListener()
{
    public void onClick(View view)
    {
        switch(view.getId)
        {
            case R.id.button1
            {
                if(button1.getTag().equals("clicked"))
                {
                    detachFragment(F2);
                    attachFragment(F1);

                    button1.setTag("notClicked");
                    button2.setTag("clicked");
                }
                else
                {
                    detachFragment(F2);
                    attachFragment(F1);

                    button1.setTag("clicked");
                    button2.setTag("notClicked");
                }
            }
            case R.id.button2
            {
                //Same thing as before except opposite
            }
        }
    }
}