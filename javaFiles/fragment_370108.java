// double click on nodes
  graphViewer.getGraphControl().addMouseListener(new MouseAdapter() {

          @Override
          public void mouseDoubleClick(MouseEvent e) {
                 toggleOpen.run();
          }
  });