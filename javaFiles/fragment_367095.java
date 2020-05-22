private void addNavigationView(ViewGroup navigationLayout, ArrayList<Perek> mishnayot) 
{
    for (int i=0;i<mishnayot.size();i++)
    {
        _counter=i;
        String currentOt=mishnayot.get(i).getOt();
        Button button = new Button(getBaseContext());
        button.setText(currentOt);
        if (_resultId==null)
            throw new IllegalAccessError("missing result id link cannot be created");
        button.setOnClickListener(new ButtonHandler(i+"",_resultId,this));

        navigationLayout.addView(button);//add the button to panel
    }
    navigationLayout.setVisibility(View.VISIBLE);
}