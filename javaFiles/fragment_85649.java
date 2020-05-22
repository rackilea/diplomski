private void makeCanvas() {
      GraphicsConfigTemplate3D gCT = new GraphicsConfigTemplate3D();
      JCanvas3D jCanvas3D = new JCanvas3D(gCT);
      Dimension canvasDim = new Dimension(400, 400);
      jCanvas3D.setPreferredSize(canvasDim);
      jCanvas3D.setSize(canvasDim);
      add(jCanvas3D, BorderLayout.CENTER);          
      Canvas3D canvas3D =  jCanvas3D.getOffscreenCanvas3D(); 

      View view = new View();
      view.setPhysicalBody(new PhysicalBody());
      view.setPhysicalEnvironment(new PhysicalEnvironment());
      view.addCanvas3D(canvas3D);

      ViewPlatform vp = new ViewPlatform();
      view.attachViewPlatform(vp);


      Transform3D viewTransform = new Transform3D();
      viewTransform.setTranslation(new Vector3d(0, 0, 20)); //move "back" a little

      TransformGroup viewTG = new TransformGroup();
      viewTG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
      viewTG.setTransform(viewTransform);

      viewTG.addChild(vp);


      viewTG.addChild(makeLight());
      viewTG.addChild(new Sphere(5));

      BranchGroup group = new BranchGroup();
      group.addChild(viewTG);
      group.addChild(makeLight());
      group.addChild(new Sphere(5));

      VirtualUniverse vu = new VirtualUniverse();
      Locale locale = new Locale(vu);  
      locale.addBranchGraph(group);
   }