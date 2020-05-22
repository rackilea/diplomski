int count = radioGroup.getChildCount();
        for (int i=0;i<count;i++) {
            View o = radioGroup.getChildAt(i);
            if (o instanceof RadioButton) {
                RadioButton selectedAnswer =(RadioButton)o;
                if(selectedAnswer.getText().equals(correctAnswer)) {
                    selectedAnswer.setTextColor(Color.GREEN);
                }
            }
        }