LinearLayout ll = new LinearLayout(getApplicationContext());
            ll.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            ll.setOrientation(LinearLayout.VERTICAL);

            TextView author = new TextView(getApplicationContext());
            TextView book = new TextView(getApplicationContext());

            LayoutParams params =  new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            ll.addView(author, params);
            ll.addView(book, params);