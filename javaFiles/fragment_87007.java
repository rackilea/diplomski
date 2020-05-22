public void testOnClickListener() {
     Editor e = new Editor();
    MyClickListener l = new MyClickListener(e);
    l.onClick();
    // however you check for correct result
    assertTrue(checkSaveEditor(e));

    }