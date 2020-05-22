dontKnowAnswerButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(currentPosition > mTestDeck.size()){
            //TO DO
            // END
        }

        myTextView.setText(currentCard.getBack());
        currentPosition++;
        knowAnswerButton.setEnabled(false);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                FlashCardActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setCurrentCard();
                        knowAnswerButton.setEnabled(true);
                    }
                });
            }
        }, PAUSE_TIMER);
    }
});

knowAnswerButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (currentPosition > mTestDeck.size()){
                //TO DO
                // END
        }
        mTestDeck.correctAnswer();
        currentPosition++;
        setCurrentCard();
    }
});