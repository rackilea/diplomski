Collections.sort(unsortList ,new Comparator<BattingOrder>(){
 @Override
 public int compare(BattingOrder one, BattingOrder two) {

      Integer orderOne = Integer.parseInt(one.battingOrder);
      Integer orderTwo = Integer.parseInt(two.battingOrder);

      //ascending order
      return orderOne.compareTo(orderTwo);

      //descending order
      //return orderTwo.compareTo(orderOne);
    }