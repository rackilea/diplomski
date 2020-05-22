LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

exampleTextLayout = (LinearLayout) inflater.inflate(R.layout.exampleTextLayout, null);
exampleTextView= (TextView) exampleTextLayout.findViewById(R.id.exampleTextView);

WindowManager.LayoutParams textViewParam = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                PixelFormat.TRANSLUCENT);
        textViewParam.gravity = Gravity.TOP | Gravity.START;

windowManager.addView(exampleTextLayout, textViewParam);
exampleTextLayout.setVisibility(View.GONE);