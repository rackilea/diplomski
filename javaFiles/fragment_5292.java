for (int i=0;i<21;i++) {
        play1[i] = new EditText(this);
        play1[i].setLayoutParams(editParams);
        play1[i].setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        play1[i].setId(View.generateViewId());
        play1[i].setInputType(InputType.TYPE_CLASS_NUMBER);
        play1[i].setHint("0000");
        if (i>2 && IsOdd(i)) {
            play1[i].setFocusable(false);
        }

        p2player1.addView(play1[i],editParams);
    }