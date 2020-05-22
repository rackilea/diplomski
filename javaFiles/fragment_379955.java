while(keyboard.hasNext())
  int num = keyboard.nextInt();
  if (num == -1) // or less than 0 ?
     break;    
  num.addFirst(num);
}