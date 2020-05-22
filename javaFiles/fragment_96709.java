final NimbusLookAndFeel laf = new NimbusLookAndFeel();
UIManager.setLookAndFeel(laf);
UIDefaults defaults = laf.getDefaults();
defaults.put("List[Selected].textForeground",
    laf.getDerivedColor("nimbusLightBackground", 0.0f, 0.0f, 0.0f, 0, false));
defaults.put("List[Selected].textBackground",
    laf.getDerivedColor("nimbusSelectionBackground", 0.0f, 0.0f, 0.0f, 0, false));
defaults.put("List[Disabled+Selected].textBackground",
    laf.getDerivedColor("nimbusSelectionBackground", 0.0f, 0.0f, 0.0f, 0, false));
defaults.put("List[Disabled].textForeground",
    laf.getDerivedColor("nimbusDisabledText", 0.0f, 0.0f, 0.0f, 0, false));
defaults.put("List:\"List.cellRenderer\"[Disabled].background",
    laf.getDerivedColor("nimbusSelectionBackground", 0.0f, 0.0f, 0.0f, 0, false));