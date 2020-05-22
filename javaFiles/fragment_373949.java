btn2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(value2 > value){
            correctCount++;
            textView1.setText("Correct = " + correctCount);
        }
          resetButtonNumbers();

    }
});