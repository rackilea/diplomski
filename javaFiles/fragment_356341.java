if(col == 0){
                characterSprite.setImg(BitmapFactory.decodeResource(getResources(),R.drawable.avdgreen1));
                Toast.makeText(getContext(), "ACTION_UP "+"X: "+characterSprite.getX()+" Y: "+characterSprite.getY(), Toast.LENGTH_LONG).show();

                col = 1;
            }