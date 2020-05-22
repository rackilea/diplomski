boolean match = false;
       for (String string : results) {
            if (string.startsWith(s)) {
                tv.setText("Start");
                match = true;
                break;
            }   
       }
       if (!match)
           tv.setText("Stop");