if(Casino.isInfoWindowShown()){
                   Intent intent = new Intent(MainActivity.this, TheRock.class);
                   startActivity(intent);

                    }

                    else if(Pin.isInfoWindowShown()){
                        Intent intent = new Intent(MainActivity.this, holyStone.class);

                        startActivity(intent);
                        }
                }