for(int i = 0; i < players.length; i+=2)
    System.out.println(players[i] + " - " + players[(i+1)%players.length]);
for(int i = 1; i < players.length; i+=2)
    System.out.println(players[i] + " - " + players[(i+1)%players.length]);

for(int dist = 2; dist < (players.length+1)/2; dist++)
for(int i = 0; i < players.length; i++)
    System.out.println(players[i] + " - " + players[(i+dist)%players.length]);

if (players.length % 2 == 0)
    for(int i = 0; i < players.length/2; i++)
        System.out.println(players[i] + " - " + players[i+players.length/2]);