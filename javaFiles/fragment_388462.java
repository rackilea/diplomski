MyClickableSpan span = new MyClickableSpan("Hello!", new MyClickableSpan.SpanClickListener() {
           @Override
           public void onSpanClicked(View widget, MyClickableSpan span)
           {
                Toast.makeText(context, span.getWord(), Toast.LENGTH_SHORT);
           }
        };
....
//add your span to the Spannable or whatever you want.