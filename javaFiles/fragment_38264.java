tableView.skinProperty().addListener(new ChangeListener<Skin>()
{
   @Override
   public void changed(ObservableValue<? extends Skin> ov, Skin t, Skin t1)
   {
      if (t1 == null) { return; }

      TableViewSkin tvs = (TableViewSkin)t1;
      ObservableList<Node> kids = tvs.getChildrenUnmodifiable();

      if (kids == null || kids.isEmpty()) { return; }
      flow = (VirtualFlow)kids.get(1);
   }
});