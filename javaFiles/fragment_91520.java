//Note: this is only a rough representation of the concept
//      what I am trying to get across, it wouldn't really
//      work like this

class Displayer{
    ValueGetter valueGetter;
    JTextField textField;

    public Displayer(){
        valueGetter = new ValueGetter();
    }

    public void display(){

        int value = valueGetter.workOutValue();

        textField.setText(value);
    }
}