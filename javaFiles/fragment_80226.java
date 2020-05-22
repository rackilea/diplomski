public class HackApplet extends WhateverRandomAppletClassItWas {
    public void init(){
         Toolkit.getDefaultToolkit().setDesktopProperty("awt.multiClickInterval", 200);
         super.init();
    }
}