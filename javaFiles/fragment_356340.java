if(col == 0){
                int ox =  550; //characterSprite.getX();
                int oy =  550;//characterSprite.getY();
               // characterSprite.setX(ox);
                //characterSprite.setX(oy);

                characterSprite = new CharacterSprite(BitmapFactory.decodeResource(getResources(),R.drawable.avdgreen1));

                Toast.makeText(getContext(), "ACTION_UP "+"X: "+characterSprite.getX()+" Y: "+characterSprite.getY(), Toast.LENGTH_LONG).show();

                col = 1;
            }