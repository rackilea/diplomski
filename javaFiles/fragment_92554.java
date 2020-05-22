for (int i = 0; i < layout.getChildCount(); i++) {
        View v = layout.getChildAt(i);
        if (v.getClass() == Button.class) {
            listA.add(v);
        }
}