actionsCol = new ColumnConfig<SensorTreeModel,ImageResource>(new ValueProvider<SensorTreeModel, ImageResource>() {
             com.sencha.project.client.Resources resources = GWT.create(com.sencha.project.client.Resources.class);
             @Override
             public ImageResource getValue(SensorTreeModel String) {

                  ImageResource add = com.sencha.project.client.Resources.INSTANCES.add();
                  return add;
                }

                @Override
                public void setValue(SensorTreeModel object, ImageResource value) {
                  if (object.getIsLeaf()) {

                  }
                }

                @Override
                public String getPath() {
                  return "actions";
                }
      });
 actionsCol.setHeader("");
actionsCol.setCell(new ImageResourceCell());