public View findViewByTag(ViewGroup vg, Object obj) {

    result = null

    if (vg == null)
        return null;

    for (int i = 0; i < vg.getChildCount(); i++) {
        //because some are not set and we don't like NullPtrs
        if (vg.getChildAt(i).getTag() != null) {
            if (vg.getChildAt(i).getTag().toString().equals(obj)) {
                Log.d("Found", "Yes." + obj.toString());

                result = vg.getChildAt(i);
            }
        }
    }
    for (int i = 0; i < vg.getChildCount(); i++) {
        if (vg.getChildAt(i) instanceof ViewGroup) {
            result = findViewByTag((ViewGroup) vg.getChildAt(i), obj);
            if (result) break;
        }
    }
    return result;
}