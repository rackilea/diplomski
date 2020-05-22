TransformGroup moveGroup = new TransformGroup();
Transform3D move = new Transform3D();
move.setTranslation(new Vector3f(0.0f, 0.0f, -10.0f));
//^^ set the Vector3f to where you want the object to be
moveGroup.setTransform(move);
moveGroup.addChild(YOUR_OBJECT);