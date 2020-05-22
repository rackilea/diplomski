MainLoop mainLoop1 = new MainLoop();
MainLoop mainLoop2 = new MainLoop();

new Thread(mainLoop1).start();
new Thread(mainLoop2).start();

mainLoop1.finished = true; // static variable also shuts down mainLoop2