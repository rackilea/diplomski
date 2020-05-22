for (int numSimulation = 0; numSimulation < 10; numSimulation++) {

  // reset the boys and girls counter before each simulation
  int numMales = 0;
  int numFemales = 0;
  double femaleToMaleRatio = 1;

    for (int mothers = 1; mothers <= 10000; mothers++) { // here the simulation starts

      while(randomGenerator.nextInt() % 2 == 0) { // while we're giving birth to boys
          numMales++; // increment the boys counter
      }
      // we've stopped giving birth to boys -> we've given birth to a girl and should stop
      numFemales++;
    }

  // we only need to calculate the female to male ratio after the simulation is done
  femaleToMaleRatio = (double) numFemales / numMales;

  // then we print the result of our simulation once its done
  System.out.printf("%4d  1 : %.5f%n", numSimulation, femaleToMaleRatio);
}