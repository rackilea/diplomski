for (Note MyNote : foo.GetNotes()) {
                LinearLayout llNoteParent = new LinearLayout(this);
                TextView tvNoteHeader = new TextView(this);
                TextView tvNoteValue = new TextView(this);

                LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                llParams.gravity = Gravity.CENTER_HORIZONTAL;
                llNoteParent.setLayoutParams(llParams);
                llNoteParent.setOrientation(LinearLayout.HORIZONTAL);
                llNoteParent.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
                llNoteParent.setPadding(R.integer.activity_horizontal_margin, R.integer.activity_vertical_margin_half, R.integer.activity_horizontal_margin, R.integer.activity_horizontal_margin);

                LinearLayout.LayoutParams tvNoteHeaderParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
                tvNoteHeaderParams.weight = 1;
                tvNoteHeader.setLayoutParams(tvNoteHeaderParams);
                tvNoteHeader.setPadding(R.integer.activity_vertical_margin_half, R.integer.activity_vertical_margin_half, R.integer.activity_vertical_margin_half, R.integer.activity_vertical_margin_half);
                tvNoteHeader.setBackground(getDrawable(R.drawable.left_text_field));
                tvNoteHeader.setGravity(Gravity.CENTER);
                tvNoteHeader.setText(MyNote.GetAbbreviatedText());

                LinearLayout.LayoutParams tvNoteValueParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT);
                tvNoteValueParams.weight = 1;
                tvNoteValue.setLayoutParams(tvNoteValueParams);
                tvNoteValue.setPadding(R.integer.activity_vertical_margin_half, R.integer.activity_vertical_margin_half, R.integer.activity_vertical_margin_half, R.integer.activity_vertical_margin_half);
                tvNoteValue.setBackground(getDrawable(R.drawable.right_text_field));
                tvNoteValue.setText(MyNote.GetText());

                llNoteParent.addView(tvNoteHeader);
                llNoteParent.addView(tvNoteValue);
                llNotes.addView(llNoteParent);
 }