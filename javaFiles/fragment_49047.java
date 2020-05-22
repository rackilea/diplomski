Preferences instancePrefsNode 
           = InstanceScope.INSTANCE.getNode("my.pref.node");

  instancePrefsNode.put("property1", "1");

  Preferences instancePrefsNode2 
           = InstanceScope.INSTANCE.getNode("my.pref.node/prefix");

  instancePrefsNode2.put("property2", "2");