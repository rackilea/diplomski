Iterator<Sprite> i = spritesArrayList.iterator();
        while (i.hasNext()) {
            sprite = i.next();   
            if (sprite.wasItTouched(event.getX(), event.getY())) {
                    i.remove();
                   sprite = new Sprite(this);  
                   sprite.update();
                   hitCount++;         
            }

        }