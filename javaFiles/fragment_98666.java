class Foo 
{
    ButtonInformation[] buttons = new ButtonInformation[]{
      new ButtonInformation(image1, "Button 1"),
      new ButtonInformation(image2, "Button 2"),
      new ButtonInformation(image3, "Button 3")
    };

    class ButtonInformation
    {
        public Image buttonImage;
        public String buttonText;

        public ButtonInformation(Image buttonImage, String buttonText)
        {
            this.buttonImage = buttonImage;
            this.buttonText = buttonText;
        }
    }
}