while((line1 = bs.readLine()) != null)
{   
    Player players1 = new Player();
    String[] token = line1.split(" ");
    players1.setfName(token[0]);
    players1.setlName(token[1]);
    players1.setScore(Integer.parseInt(bs.readLine()));

    player.add(players1);
}