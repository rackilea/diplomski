int lastDieSum = die1[i-1] + die2[i-1];

if (lastDieSum == dieSum) {
     currentStreak++;
     if (currentStreak > biggestStreak) {
         biggestStreak = currentStreak;
     } 
} else {
     currentStreak = 1;
}