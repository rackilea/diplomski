int winner = 0;
for (i = 0; i < num_choices; i++) {
    if (rnd < choice_weight[i]){
       winner = i+1;
       break;
    }
    rnd -= choice_weight[i];
}