for (int i = 1; i <= daysMultiply; i++) {
            dailyTotal = startingOrganisms * dailyPopulation * .01;
            startingOrganisms = startingOrganisms + dailyTotal;
            //startingOrganisms = dailyTotal2
            System.out.println("Population for day " + i + " = " + startingOrganisms);
        }