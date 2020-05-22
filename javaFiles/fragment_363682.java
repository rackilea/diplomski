ArrayList<Integer> numbers = new ArrayList<Integer>();
 boolean vowel_added = false;
    Random rnd = new Random();
    while (numbers.size()<=3) {
      int randomInteger = rnd.nextInt(answers.length());
      if (!numbers.contains(randomInteger)) {

            if (answers[randomInteger]).equalsIgnoreCase("Vowel"))
             {
                 if (! vowel_added)
                 {
                   vowel_added = true;
                   numbers.add(randomInteger);
                 }
             }
             else
             {
                 numbers.add(randomInteger);
             }
       }
    }
    if (! vowel_added) {
      int index = rnd.nextInt(numbers.size());//this random to set the index of vowel at random position
      numbers.set(index,3);//you can find the index of one vowel and put here
    }
    button1.setText(answers[numbers.get(0)]);
    button2.setText(answers[numbers.get(1)]);
    button3.setText(answers[numbers.get(2)]);