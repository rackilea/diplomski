for(int i = 0; i < spritesArrayList.size(); i++) {
            sprite = spritesArrayList.get(i);
            if (sprite.wasItTouched(event.getX(), event.getY())) {
                   spritesArrayList.remove(i--);
                   sprite = new Sprite(this);  
                   sprite.update();
                   hitCount++;         
            }

      }