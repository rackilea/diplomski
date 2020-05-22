for (int i = 0; i < 100000000; i++) {
     double sum = 0;
     sum += sum_trials(composition[0], 107.0/10000.0, 13.003354378, 12.0); // carbon trials
     sum += sum_trials(composition[1], 107.0/10000.0, 13.003354378, 12.0); // hydrogen trials
     sum += sum_trials(composition[2], 107.0/10000.0, 13.003354378, 12.0); // nitrogen trials
     sum += sum_trials(composition[3], 107.0/10000.0, 13.003354378, 12.0); // oxygen trials
     sum += sum_trials(composition[4], 107.0/10000.0, 13.003354378, 12.0); // sulfur trials

     if (sum > threshold) {
     } else {
     }
   }