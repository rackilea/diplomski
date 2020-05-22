public static void main(String args[]) 
{
    Scanner input = new Scanner(System.in);
    System.out.println("Enter attack low: ");

    double low = input.nextDouble();

    Attacker attacker = new Attacker();
    attacker.setLow(low);

    Defender defender = new Defender();

    Battle battle = new Battle(attacker, defender); 
    battle.result();
}