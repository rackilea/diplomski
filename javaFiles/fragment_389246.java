trainer.getSprite().setPosition(
                        (trainer.getPosx() - (main.getPosx() < width / 4 ? width / 4
                                : main.getPosx() > im.getWidth() - width / 4 ? im.getWidth() - width / 4
                                        : main.getPosx()))
                                * 2 + width / 2,
                        (trainer.getPosy() - (main.getPosy() < height / 4 ? height / 4
                                : main.getPosy() > im.getHeight() - height / 4 ? im.getHeight() - height / 4
                                        : main.getPosy()))
                                * 2 + height / 2);