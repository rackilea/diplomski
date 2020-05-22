int minValue = 1;
int maxValue = 12;

EditText input = (EditText) findViewById(R.id.txtInput);
input.setInputType(InputType.TYPE_CLASS_NUMBER);
input.setFilters(new InputFilter[]
    {
        new InputFilterMinMax(minValue, maxValue), 
        new InputFilter.LengthFilter(String.valueOf(maxValue).length())
    });
input.setKeyListener(DigitsKeyListener.getInstance("0123456789"));