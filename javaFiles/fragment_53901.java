onCreate:
    prefs = <load shared preferences>;
    yourInt = prefs.getInt("name of your int", 0);
    // do whatever with yourInt

onPause: // maybe not onPause, maybe you want to save each time it changes?
    prefs = <load shared preferences>;
    editor = prefs.edit();
    editor.putInt("name of your int", yourInt);
    editor.commit();