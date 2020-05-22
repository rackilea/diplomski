teamName = bufferedScanner.next();
            won = lineScanner.nextInt();
            drawn = lineScanner.nextInt();
            lost = lineScanner.nextInt();
            goalsFor = lineScanner.nextInt();
            goalsAgainst = lineScanner.nextInt();

            Team aTeam = new Team(lineScanner.next());
            aTeam.setWon(lineScanner.nextInt());
            aTeam.setDrawn(lineScanner.nextInt());
            aTeam.setLost(lineScanner.nextInt());
            aTeam.setGoalsFor(lineScanner.nextInt());
            aTeam.setGoalsAgainst(lineScanner.nextInt());