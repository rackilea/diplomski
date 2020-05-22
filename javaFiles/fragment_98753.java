Intent intentBundle = getActivity().getIntent();
        String question_cat = intentBundle.getStringExtra("question_cat");
        String Number = intentBundle.getStringExtra("Num");
        String Message = intentBundle.getStringExtra("Mess");
        Log.i("Result : ", Number );
        values.add(Number);