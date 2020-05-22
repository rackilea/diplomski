mediaPlayerServiceInt = new Intent(PlayActivity.this, MediaPlayerService.class);
                mediaPlayerServiceInt.setAction(Constants.START_ACTION);
                mediaPlayerServiceInt.putExtra(Constants.URI, medUri);
                mediaPlayerServiceInt.putExtra(Constants.TITLE, selectedMed.getTitle());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(mediaPlayerServiceInt);
                } else {
                    startService(mediaPlayerServiceInt);
                }
                bindMediaPlayerService();