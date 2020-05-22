// check if activity B is created and running:
                if (intent == null) {
                    System.out.println("Creating Activity  - Intent is null");
                    intent = new Intent(context, ActivityB.class);
                    intent.putExtras(ImagedownloaderActivityBundle);
                    startActivity(intent);
                }else {
                    System.out.println("Reloading Activity  - Intent exists");
                    finish();
                    intent = new Intent(context, ActivityB.class);
                    intent.removeExtra("playlistsList");
                    intent.putExtras(ImagedownloaderActivityBundle);
                    startActivity(intent);
                }