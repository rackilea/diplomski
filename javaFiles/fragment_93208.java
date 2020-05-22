Color bgColor = new Color("99999");
UIDefaults defaults = new UIDefaults();
defaults.put("EditorPane[Enabled].backgroundPainter", bgColor);
jeditorpane.putClientProperty("Nimbus.Overrides", defaults);
jeditorpane.putClientProperty("Nimbus.Overrides.InheritDefaults", true);
jeditorpane.setBackground(bgColor);