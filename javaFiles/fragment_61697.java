System.out.println(rnd);

int winner=0;
int rangeHigh=0;
for (i = 0; i < num_choices; i++) {
   rangeHigh += choice_weight[i];
   if (rnd < rangeHigh){
      winner = (i+1);
      break;
   }
}
System.out.println("lucky winner number: " + winner);