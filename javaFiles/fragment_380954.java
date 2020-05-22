ActionMap actionMap = tree.getActionMap();
actionMap.remove("cut");
actionMap.getParent().remove("cut");
actionMap.remove("copy");
actionMap.getParent().remove("copy");
actionMap.remove("paste");
actionMap.getParent().remove("paste");