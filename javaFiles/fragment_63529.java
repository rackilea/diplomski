CountDownLatch latch = new CountDownLatch(1);
input = new InputPanel(config, files, latch);
JScrollPane inputScroll = new JScrollPane(input);

cySouthPanel.add("MyProgram", inputScroll);
cySouthPanel.setSelectedIndex(cySouthPanel.indexOfComponent("MyProgram"));

latch.await();