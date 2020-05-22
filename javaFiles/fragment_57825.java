class Player {
    // ...
}

class FooPlayer extends Player {
    void solveInt(int num) { 
        // ... 
    }
}

class BarPlayer extend Player {
    void solveString(String s) {
        // ...
    }
}

Player[] players = new[] {new FooPlayer(), new BarPlayer()};
// this is the sort of code you want to work
for (Player p : players) {
    p.solveInt(123);
}