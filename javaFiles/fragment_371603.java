this.setLayout(new MigLayout(
    "fill",  // Layout
    "",         // Column
    ""));       // Row
this.add(map, "width 400:600:, dock center, growy");
this.add(sideBar, "width 250:300:350, dock east, growy");