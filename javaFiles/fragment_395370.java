public static native void exportStaticMethods() /*-{

    $wnd.pingApp = $entry((function) {
                       return @com.application.PokePingClass::pingApp()();
                   });

    $wnd.pokeApp = $entry((function) {
                       return @com.application.PokePingClass::pokeApp()();
                   });
}-*/