public void addClick2(View Button){
Random r = new Random();
int Low = 0;
int High = 20;
int count = 0;
N = r.nextInt(High-Low) + Low;
}

public void addClick3(View Button){
      count++;
      number_output = eNumber.getText().toString(); //get the existing comments

      try {
            int compareNum = Integer.parseInt(number_output);
             if(compareNum == N){
                  numOutput.setText(number_output + " Good Guess!");//Display the new comments
                  numOutput.setBackgroundColor(Color.GREEN);
              }else if(compareNum > N){
                  numOutput.setText(number_output + " is too HIGH!");//Display the new comments
                  numOutput.setBackgroundColor(Color.RED);
              }else if(compareNum < N){
                  numOutput.setText(number_output + " is too LOW!");//Display the new comments
                  numOutput.setBackgroundColor(Color.RED);
              }
        }
        catch (NumberFormatException e) {
        }
        if(count == 3){
            //set your game over message
        }
    }
}