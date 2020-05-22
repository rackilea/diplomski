//Game Main Loop
                while (this.running) {

                    bg.draw(); // DON'T SWAP BUFFERS!
                    player.draw(); // DON'T SWAP BUFFERS!
                    // draw other entities
                    player.moveHorizontal(left, right, speed); //Dont worry about this line.
                    this.tick(50);
                    this.strategy.show(); // This needs to be the very last thing you do. You're swapping buffers here, which only needs to be done once per frame.
                }