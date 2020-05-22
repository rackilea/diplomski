// calculate the time it took to render the frame
            elapsedTime = System.currentTimeMillis() - frameStart;
            // sync the framerate
            try {
                // make sure framerate milliseconds have passed this frame
                if (elapsedTime < framerate) {
                    Thread.sleep(framerate - elapsedTime);
                }
                else {
                    // don't starve the garbage collector
                    Thread.sleep(5);
                }
            }
            catch (InterruptedException e) {
                break;
            }
            ++frameCount;
            totalElapsedTime += (System.currentTimeMillis() - frameStart);
            if (totalElapsedTime > 1000) {
                reportedFramerate = (long) ((double) frameCount
                        / (double) totalElapsedTime * 1000.0);
                // show the framerate in the applet status window
                System.out.println("fps: " + reportedFramerate);
                // repaint();
                frameCount = 0;
                totalElapsedTime = 0;
            }