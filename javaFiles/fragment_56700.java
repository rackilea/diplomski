for(int i = 0; i < players.length-1; i+=2)
    System.out.println(players[i] + " - " + players[i+1]);
for(int i = 1; i < players.length-1; i+=2)
    System.out.println(players[i] + " - " + players[i+1]);

for(int dist = 2; dist < players.length; dist++)
for(int i = 0; i + dist < players.length; i++)
    System.out.println(players[i] + " - " + players[i+dist]);