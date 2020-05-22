Options options = serviceClient.getOptions();
serviceClient.engageModule("test");

options.setProperty(RampartMessageData.KEY_RAMPART_POLICY,loadPolicy("policy.xml"));
serviceClient.engageModule("rampart");
..