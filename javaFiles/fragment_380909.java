roattiondeg = Math.toRadians(tournsc.nextInt());

    triangleh = ((Math.pow(coordx, 2)) + (Math.pow(coordy, 2)));

    angle = Math.atan(coordy/coordx));
    newangle = roattiondeg + angle;
    ansx = Math.sqrt(triangleh)*Math.cos(newangle);
    ansy = Math.sqrt(triangleh)*Math.sin(newangle);
    System.out.println("Nouvelles coordoner : " + ansx + "," + ansy);