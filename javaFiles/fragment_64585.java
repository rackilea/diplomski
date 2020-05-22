//Create panel for the SVG content
    StringReader srdrSVG = new StringReader(sbSVG.toString());
    URI uriSVG = SVGCache.getSVGUniverse().loadSVG(srdrSVG, SVG_MIMIC);
    SVGPanel svgPanel = new SVGPanel();
    svgPanel.setBackground(Color.BLACK);
    svgPanel.setMaximumSize(dimMax);
    svgPanel.setAntiAlias(false);
    svgPanel.setSvgURI(uriSVG);
    //Create application window/container           
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setUndecorated(true);
    frame.setMaximumSize(dimMax);
    gfxdevice.setFullScreenWindow(frame);
    frame.add(svgPanel);            
    frame.setVisible(true);