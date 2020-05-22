Anchor anchor = hitResult.createAnchor();
AnchorNode anchorNode = new AnchorNode(anchor);

node.getScaleController().setMinScale(0.5f);
node.getScaleController().setMaxScale(3.0f);

node.setLocalScale(new Vector3(2.25f, 2.25f, 2.25f));
node.setParent(anchorNode);