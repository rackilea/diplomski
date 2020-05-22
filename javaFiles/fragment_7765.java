TextView the_text_view = (TextView) v.findViewById(R.id.the_text);
      LinearLayout ll_btn_holder = (LinearLayout) v.findViewById(R.id.btn_holder);
      TextView hello_text_view = (TextView) v.findViewById(R.id.hello_text);
        hello_text_view.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                the_text_view.setVisibility(View.VISIBLE);
                ll_btn_holder.setVisibility(View.VISIBLE);
            }
        });