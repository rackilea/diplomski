myGame extends ApplicationAdapter{
           public static int count;
           public static bitmapFont font;
           public SpriteBatch batch;
           public static Preferences prefs;  
           public void create()
           {
           batch=new SpriteBatch();
           font=new font(Gdx.files.internla("myFont.png"));
           public static Preferences prefs;
        // this is for setting up the storage for the current project 
           prefs = Gdx.app.getPreferences("myGame");
            }
           public void incrementCount()
          {
          count++;
          if(count>100){
         // here "countValue" is the key(which is the reference to the data)  and "count" is the vlaue(the data). the value is stored in key value method.

          prefs.putInteger("countValue", count);

         // is used to flush the data in to the storage
           prefs.flush();
             }
           public void render()
            {
         // getting the stored value from the preference
            pref.getInteger("countValue",countValue);
            batch.begin();
            batch.draw(font,countValue+"stored value",0,0)
            batch.end()
               }

         // this is the simple way to store the data into the device memory . it will work in both the android and the IOS