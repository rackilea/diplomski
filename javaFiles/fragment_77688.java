tts.setOnUtteranceCompletedListener(new OnUtteranceCompletedListener() {

                @Override
                public void onUtteranceCompleted(String arg0) {
                    // TODO Auto-generated method stub
                    if (mShouldSpeak) 
                    {
                        tts.speak("hello world", TextToSpeech.QUEUE_FLUSH, hash);
                    }

                }
            });