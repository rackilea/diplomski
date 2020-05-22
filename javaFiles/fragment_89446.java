for (Snake name : map.keySet()) {
        if (name != null) {
            if (name.player.equals(snake.player)) {
                name.copyValues(snake);
            }
            objout = new ObjectOutputStream(map.get(name)
                    .getOutputStream());
            objout.writeObject(move);
            objout.flush();
//rest of code goes here. Closing brackets as above.