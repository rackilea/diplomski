private static final float MIN_SCENE_HEIGHT_IN_GAME_UNITS= 480f; //FOR EXAMPLE
private static final float MIN_SCENE_WIDTH_IN_GAME_UNITS= 760f;

   if (((float)screenWidthInPixels/(float)screenHeightInPixels) > (MIN_SCENE_WIDTH_IN_GAME_UNITS/MIN_SCENE_HEIGHT_IN_GAME_UNITS)){
       orthoCam.setToOrtho(false, MIN_SCENE_HEIGHT_IN_GAME_UNITS*(float)screenWidthInPixels/(float)screenHeightInPixels, MIN_SCENE_HEIGHT_IN_GAME_UNITS);
   } else {
       orthoCam.setToOrtho(false, MIN_SCENE_WIDTH, MIN_SCENE_WIDTH_IN_GAME_UNITS*(float)screenHeightInPixels/(float)screenWidthInPixels);
   }