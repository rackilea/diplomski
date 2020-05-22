String code = "Hello There"; //declare variable globally
int i = 0; //declare globally
TextView view; //declare globally

public void loopCode()
    {
                view = (TextView) findViewById(R.id.code_txt);
                //String s = "";
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i != code.length()) { 
                                view.append(" " + code.charAt(i));
                                i++;
                                handler.postDelayed(this, 1000);
                            }
                        }
                    }, 1000);
                }
     }