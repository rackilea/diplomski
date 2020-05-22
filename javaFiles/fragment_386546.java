TableRow row = new TableRow(activityContext);

            TableLayout.LayoutParams td_tr = new TableLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

            row.setWeightSum(10);
            row.setLayoutParams(td_tr);
            row.setGravity(Gravity.CENTER);
            row.setBackgroundColor(Color.parseColor("#D2D2D2"));

            TextView tv= new TextView(activityContext);
            tv.setText(String.valueOf(i));
            tv.setTextAppearance(activityContext, style.tvBoldRow);
            tv.setLayoutParams(new TableRow.LayoutParams(0 , LayoutParams.WRAP_CONTENT, 1)); // Here you can set weight to your TextView.
            tv.setPadding(2, 2, 2, 2);
            tv.setGravity(Gravity.CENTER);
            row.addView(tv);