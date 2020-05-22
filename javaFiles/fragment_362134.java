System.out.println("Video decoding complete");
                this.decoderComplete = true;
                //wait until notified that packets are done draining
                synchronized(this)
                {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        videoComplete = true;
                        this.container.close();
                        e.printStackTrace();
                    }
                }
                Gdx.app.log("Status", videoPath + " completed playing successfully.");
                videoComplete = true;
                this.container.close();