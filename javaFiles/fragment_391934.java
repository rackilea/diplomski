// code for creating the list
private List<Player> players = ...;
private List<Double> chances = new ArrayList<>();
private double acc;

public void createChances(){
    acc = 0.0;
    for( Player player: players ){
        acc += (player.getKarma() + 1001)/2000.0;
        chances.add( acc );
    }
}

// code for using the list
private Random random = new Random();

// pick a player
public Player pick(){
    Player picked;
    double rc = random.nextDouble()*acc;
    for( int ic = 0; ic < chances.size(); ++ic ){
        if( rc < chance.get(ic) ){
            picked = players.get(ic);
            break;
        }
    return picked;
}