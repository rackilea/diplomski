if(status==TextToSpeech.SUCCESS){
                    result=t_speech.setLanguage(new Locale("tr", "TR"));
                }
                else{
                    Toast.makeText(getApplicationContext(),"initialization of tts failed",Toast.LENGTH_LONG).show();
                }