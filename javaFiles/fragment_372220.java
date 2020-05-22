while(guess!=number) {
                    if(guess>number) {
                        result.setText("Guess Too High. Try Again.");
                        result.setForeground(Color.CYAN);
                    } else if(guess<number) {
                        result.setText("Guess Too Low. Try Again.");
                        result.setForeground(Color.CYAN);
                    } else {
                        result.setText("Unknown Error");
                        result.setForeground(Color.RED);
                    }
                }