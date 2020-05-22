Process proc = new ProcessBuilder(
                "convert", 
                "test.png", 
                "-gravity", "west", 
                "-pointsize","13", 
                "-annotate", "+50+300", 
                processedText, 
                "test.png").start();