if(isChecked)
            {
                System.out.println("Toggle Button Is On");

                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("YES",  true); // value to store
                editor.commit();
                strBooleanValue=preferences.getBoolean("YES",true);
                strToggleVlaue=String.valueOf(strBooleanValue);
                System.out.println("Toggle Button Value Is =" + strToggleVlaue);


            }
 else
        {

                System.out.println("Toggle Button Is Off");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("NO",  false); // value to store
                editor.commit();
                strBooleanValue=preferences.getBoolean("NO", false);
                strToggleVlaue=String.valueOf(strBooleanValue);
                System.out.println("Toggle Button Value Is =" + strToggleVlaue);


        }