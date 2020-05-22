for (int i = 1; i <= daysMultiply; i++) {
            dailyTotal = startingOrganisms * dailyPopulation * .01;
            dailyTotal2 = startingOrganisms + dailyTotal;
            startingOrganisms = dailyTotal2;
            System.out.println("Population for day " + i + " = " + dailyTotal2);
        }