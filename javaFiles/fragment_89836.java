if (diceRollOne == diceRollTwo || diceTotal == prevDiceTotal) {
            System.out.println("After " + loop + " loops the");
            System.out.println("Numbers Match, YOU GET NOTHING, YOU LOSE, GOOD DAY SIR!");
            System.exit(0);
        }

        prevDiceTotal = diceTotal;