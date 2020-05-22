SpannableStringBuilder text = new SpannableStringBuilder();
text.append(getString(R.string.before));
//Now create a ClickableSpan
ClickableSpan clickableSpan = new ClickableSpan() {  
            @Override  
            public void onClick(View view) {                

                d.show(); //Here dialog will be displayed
            }  
        };
//Now append the TOS string
text.append(getString(R.string.popup));
//Declare that the "TOS" string is a clickableSpan
text.setSpan(clickableSpan, getString(R.string.before).length(), getString(R.string.before).length()+getString(R.string.popup).length(), 0); //Check on API setSpan method
((CheckBox)findViewById(yourview)).setMovementMethod(LinkMovementMethod.getInstance()); 
((CheckBox)findViewById(yourview)).setText(text, BufferType.SPANNABLE); //AAAAND WE'RE DONE!