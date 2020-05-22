public void testSearch() { 
   Instrumentation instrumentation = getInstrumentation(); 
   instrumentation.sendKeyDownUpSync(KeyEvent.KEYCODE_SEARCH); 
   instrumentation.sendCharacterSync(KeyEvent.KEYCODE_F); 
   instrumentation.sendCharacterSync(KeyEvent.KEYCODE_O); 
   instrumentation.sendCharacterSync(KeyEvent.KEYCODE_O);
   //Assert here for whatever you want. 
}