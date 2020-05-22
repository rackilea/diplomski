private ListView getLv(){
      ListView lv = new ListView(PANEL, new PropertyModel(this, "someList")) {
         @Override
         protected void populateItem(ListItem item) {
            Integer type = item.getModelObject().getType();
            if (type == 1) {
               item.add(new PanelType1("panel", item.getModelObject().someIdMaybe));
            } else if (type == 2) {
               item.add(new PanelType2("panel", item.getModelObject().someIdMaybe));
            }
         }
      };
      return lv;
   }