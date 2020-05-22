private EditText et1;  

then in the onCreate() function...

et1 = (EditText)findViewById(R.id.editText_text);

@Override
public void onClick(View view)
{
    if(view.getId() == R.id.editText_text)
    {
        String str = et1.getText().toString();
    }
}