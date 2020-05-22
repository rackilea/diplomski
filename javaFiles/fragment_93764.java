@Override
public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
    try {
        String newVal = dest.toString().substring(0, dstart) + dest.toString().substring(dend);

        newVal = newVal.substring(0, dstart) + source.toString() + newVal.substring(dstart);

        //Add this line to allow Negative values
        if(newVal.equalsIgnoreCase("-") && min < 0)
            return null;

        int input = Integer.parseInt(newVal);
        if (isInRange(min, max, input))
            return null;
    } catch (NumberFormatException nfe) {
        nfe.printStackTrace();
    }

    return "";
}