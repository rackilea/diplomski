Spawn s = expectInit.spawn("/bin/sh");           
s.send("echo debraj\n");

Thread.sleep(200);                      // Pause for 0.2s

System.out.println("Output->"+s.getCurrentStandardOutContents());
s.expectClose();