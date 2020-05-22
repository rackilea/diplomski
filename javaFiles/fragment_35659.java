Display display = getWindowManager().getDefaultDisplay(); 
int schermBreedte =0;
if(display.getWidth()>display.getHeight())
    schermBreedte=display.getHeight()
else
    schermBreedte=display.getWidth();
int knopAfmeting = schermBreedte/16;