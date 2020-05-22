window.addHierarchyListener(new HierarchyListener() {
    @Override
      public void hierarchyChanged(HierarchyEvent e) {
        System.out.println("valid: " + window.isValid());
        System.out.println("showing: " + window.isShowing());
      }
  });