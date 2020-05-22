if (type.equals(TAG_ENTITY_ATTRIBUTE_VALUE_GAMEBUTTON1))
{
    final ButtonSprite levelObject = new ButtonSprite(x, y, resourcesManager.gamebutton1_region, vbom, new  OnClickListener()
    {

        @Override
        public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX, float pTouchAreaLocalY) 
        {       
            //This button sprite has been clicked so lets enable any child sprites

            EnableChildButtons(this); //See sub routine later

        }
     });
     //For game button 1, we will enable it,
     levelObject.setEnabled(true);
     levelObject.setColor(Color.WHITE);
     //Hereafter for further buttons, although the rest of the code will be the same
     //will be disabled after creation with the following two lines in place of the latter
     // levelObject.setEnabled(false);
     // levelObject.setColor(Color.BLACK);
}
//...(rest of your code in previous post)