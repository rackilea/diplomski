Graphics2D g = s.getGraphics();  
      while(cumTime - startingTime < 5000) {
        long timePassed = System.currentTimeMillis() - cumTime;
        cumTime += timePassed;
        update(timePassed);

        //draw and update the screen
        draw(g);
        g.dispose();
        s.update();

        try{
            Thread.sleep(20);
        }catch(Exception ex) {
            System.err.println("Error: " + ex);
        }
    }
}