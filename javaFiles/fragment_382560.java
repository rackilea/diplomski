SequenceAction sequence = Actions.sequence();

    for(int i = 0; i < string.length; i++) {
        sequence.addAction(Actions.run(new Runnable() {
                                             @Override
                                             public void run() {
                                                a.setText(strings[i]); 
                                                a.setPosition(a.getWidth() * 0.2f, 50);                                                            
                                             }
                                        }, Actions.scaleBy(30, 20, 5)));