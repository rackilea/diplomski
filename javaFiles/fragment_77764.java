if (rosan.contains(":p")){
            int span = abc.indexOf(":p");
            res = getResources().getDrawable(R.drawable.myImage); 
            res.setBounds(0, 0, res.getIntrinsicWidth(), res.getIntrinsicHeight());
            span = new ImageSpan(res, ImageSpan.ALIGN_BASELINE);
            ss.setSpan(span, startSpan, startSpan+2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
            rosan = rosan.replaceFirst(":D","  "); //replace with two blank spaces.
        }