void setTextViewColor(TextView textView, int color) {
          textView.setTag((Integer)color);
          textView.setColor(color);
    }

    void restoreTextViewToItsDefaultColor(TextView textView) {
        Integer myColor=(Integer)textView.getTag();
        textView.setColor(myColor);
    }