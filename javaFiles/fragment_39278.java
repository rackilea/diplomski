if(a.equals("FIRE")){
    in.next();// for @
    String num[] = in.nextLine().split(",");
    float x = Float.parseFloat(num[0].trim());
    float y = Float.parseFloat(num[1].trim());
    fires.add(new Fire(x, y, randGen));
}