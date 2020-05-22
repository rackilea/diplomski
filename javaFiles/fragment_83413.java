private void EnableChildButtons(final ButtonSprite mButtonSprite)
{
    //To cut down on syntax length get a pointer to the button user data
    final levelObjectUserData mUserData = ((levelObjectUserData) (mButtonSprite.getUserData()));

    //We will be careful and run this on the update so we do not alter states
    //while they are currently being processed by the update thread!
    mActivity.runOnUpdateThread(new Runnable()
    {
        @Override
        public void run()
        {
            //Go through all of the buttons child ids
            for (int i = 0;i<mUserData.ChildIDs.size();i++)
            {

                //Locate the button with that ID as will be refernced in our levelObjects
                //linked list
                for (int j = 0;j<levelObjects.size();j++)
                {
                    final int ButtonSpriteID = ((levelObjectUserData) (levelObjects.get(j).getUserData())).ID;

                    if (mUserData.ChildIDs.get(i) == ButtonSpriteID)
                    {
                        //We have found a child button, so enable it!
                        ((ButtonSprite) levelObjects.get(j)).setEnabled(true);
                        ((ButtonSprite) levelObjects.get(j)).setColor(Color.WHITE);
                    }
                }

            }
        }

     });
}