public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    double hp = 10;
    while(hp > 1) { //Moved The loop
        System.out.println("how much damage do you wish to do?");
        double attack = input.nextDouble();
        //double damage = hp - attack;//not needed
        hp = hp - attack;//Added this line
        //System.out.println(damage);//not needed
        System.out.println("health = " + Math.round(hp));
        if(hp == 0)
            System.out.println("Dead");
        else
            System.out.println("Alive");
    }
}