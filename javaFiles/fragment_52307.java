persistenceManager().currentTransaction().begin();
CustomClass customObj = new CustomClass();
customobj.setName("someName");
//set other values    
persistenceManager.makePeristent(customObj);//persist
//comment this
//SomeUtil.getRoot().getChildElements().add(customObj);//add to its owner
persistenceManager.currentTransaction().commit();