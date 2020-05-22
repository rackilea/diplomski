sideBar = new SideBarView(borderPane);

ScrollPane sideBarScroller = new ScrollPane(sideBar);
sideBarScroller.setFitToWidth(true);

borderPane.setRight(sideBarScroller);