for (int i = 0;i<levelObjects.size();i++)
{

        final int ButtonSpriteChild  = ((levelObjectUserData) (levelObjects.get(i).getUserData())).ChildID;
        for (int j = 0;j<levelObjects.size();j++)
        {
            final int ButtonSpriteID = ((levelObjectUserData) (levelObjects.get(j).getUserData())).ID;

            if (ButtonSpriteChild  == ButtonSpriteID)
            {
                //Draw your line here between ButtonSprite levelObjects.get(i)
                //and ButtonSprite levelObjects.get(j) - the child that matches up
            }
        }

}