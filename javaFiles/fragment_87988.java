public SVGApplication(){
      JSVGCanvas svg = new JSVGCanvas();
      // location of the SVG File
      svg.setURI("file:/C:/Users/Linda/Desktop/test.svg");
      // JPanel panel = new JPanel(); // *** what is this for? ***
      // panel.add(svg);
      add(svg);
 }