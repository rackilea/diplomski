Rating r1 = new Rating(); //An instance of Rating
r1.addVote(4.3d);
r1.addVote(4d);
r1.addVote(2.5d);
r1.addVote(5d);

Rating r2 = new Rating(); // Another instance of Rating
r2.addVote(4d);

AssertEquals(r1.getNumVotes(), 4);
AssertEquals(r2.getNumVotes(), 1);