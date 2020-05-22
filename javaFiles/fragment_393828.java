public Image takeSnapshot(Scene scene, final Node... hideNodes) {
  for (Node node: hideNodes) node.setVisible(false);
  Image image = scene.snapshot(null);
  for (Node node: hideNodes) node.setVisible(true);

  return image;
}