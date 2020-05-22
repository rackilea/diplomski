public class LoadingScreen extends MainScreen
{
public LoadingScreen()
{       
    createGUI();                               
}

private void createGUI()
{
    add(new LabelField("CheckboxField Demo"));


    HorizontalFieldManager HFM1 = new HorizontalFieldManager(Field.FIELD_HCENTER);

    CheckboxField checkBoxField3 = new CheckboxField("Option 1", false, Field.FIELD_VCENTER)
    {
        protected void drawFocus(Graphics graphics, boolean on) 
        {               
            super.drawFocus(graphics, false);
        } 

        protected void layout(int width, int height) 
        {
            super.layout(150, height);
        }

    };

    checkBoxField3.setMargin(0, 10, 0, 0);
    HFM1.add(checkBoxField3);

    CheckboxField checkBoxField4 = new CheckboxField("Option 2", false,  Field.FIELD_VCENTER)
    {
        protected void drawFocus(Graphics graphics, boolean on) 
        {               
            super.drawFocus(graphics, false);
        }
        protected void layout(int width, int height) 
        {
            super.layout(150, height);
        }
    };
    HFM1.add(checkBoxField4);

    HFM1.setMargin(10,0,0,0);
    add(HFM1);              
}
}