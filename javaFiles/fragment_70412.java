public class Resize {
        double eY = 0;
        double eX = 0;
        double eStrtY = 0;
        double eStrtX = 0;
        double sceneStrtY = 0;
        double sceneStrtX = 0;
        double minW = 600;
        double minH = 600;
        double w = 0;
        public Resize(Stage stage, double w) {

            Scene scene = stage.getScene();
            AnchorPane root = (AnchorPane)scene.getRoot();
    this.w = w;
    root.setOnMousePressed(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            eStrtY = e.getSceneY();
            eStrtX = e.getSceneX();
            sceneStrtY = e.getSceneY();
            sceneStrtX = e.getSceneX();
        }
    });

    root.setOnMouseMoved(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
        //  double w = 8;
            double X = event.getSceneX();
            double Y = event.getSceneY();
            double sW = scene.getWidth();
            double sH = scene.getHeight();

            if(((X<w)&&(Y<w))||((X<2*w)&&(Y<w))||((Y<2*w)&&(X<w))) {
                scene.setCursor(Cursor.NW_RESIZE);
                eY = stage.getY();
                eX = stage.getX();
                root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        if(((eStrtX<w)&&(eStrtY<w))||((eStrtX<2*w)&&(eStrtY<w))||((eStrtY<2*w)&&(eStrtX<w))) {
                            if(stage.getHeight()+(eY-e.getScreenY())>minH) {
                                stage.setY(e.getScreenY());
                                stage.setHeight(stage.getHeight()+(eY-e.getScreenY()));
                                eY = e.getScreenY();
                            }
                            if(stage.getWidth()+(eX-e.getScreenX())>minW) {
                                stage.setX(e.getScreenX());
                                stage.setWidth(stage.getWidth()+(eX-e.getScreenX()));
                                eX = e.getScreenX();
                            }
                        }
                    }
                });
            }
            else
                if(((X>sW-w)&&(Y<w))||((X>sW-2*w)&&(Y<w))||((X>sW-w)&&(Y<2*w))) {
                    scene.setCursor(Cursor.NE_RESIZE);
                    eY = stage.getY();
                    eX = stage.getX() + stage.getWidth();
                    root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            if(((eStrtX>sW-w)&&(eStrtY<w))||((eStrtX>sW-2*w)&&(eStrtY<w))||((eStrtX>sW-w)&&(eStrtY<2*w))) {
                                if(stage.getHeight()+(eY-e.getScreenY())>minH) {
                                    stage.setY(e.getScreenY());
                                    stage.setHeight(stage.getHeight()+(eY-e.getScreenY()));
                                    eY = e.getScreenY();
                                }
                                if(stage.getWidth()-(eX-e.getScreenX())>minW) {
                                    stage.setWidth(stage.getWidth()-(eX-e.getScreenX()));
                                    eX = e.getScreenX();
                                }
                            }
                        }
                    });
                }
                else
                    if(((X>sW-w)&&(Y>sH-w))||((X>sW-2*w)&&(Y>sH-w))||((X>sW-w)&&(Y>sH-2*w))) {
                        scene.setCursor(Cursor.SE_RESIZE);
                        eY = stage.getY() + stage.getHeight();
                        eX = stage.getX() + stage.getWidth();
                        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent e) {
                                if(((eStrtX>sW-w)&&(eStrtY>sH-w))||((eStrtX>sW-2*w)&&(eStrtY>sH-w))||((eStrtX>sW-w)&&(eStrtY>sH-2*w))) {
                                    if(stage.getHeight()-(eY-e.getScreenY())>minH) {
                                        stage.setHeight(stage.getHeight()-(eY-e.getScreenY()));
                                        eY = e.getScreenY();
                                    }
                                    if(stage.getWidth()-(eX-e.getScreenX())>minW) {
                                        stage.setWidth(stage.getWidth()-(eX-e.getScreenX()));
                                        eX = e.getScreenX();
                                    }
                                }
                            }
                        });
                    }
                    else
                        if(((X<w)&&(Y>sH-w))||((X<2*w)&&(Y>sH-w))||((X<w)&&(Y>sH-2*w))) {
                            scene.setCursor(Cursor.SW_RESIZE);
                            eY = stage.getY() + stage.getHeight();
                            eX = stage.getX();
                            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent e) {
                                    if(((eStrtX<w)&&(eStrtY>sH-w))||((eStrtX<2*w)&&(eStrtY>sH-w))||((eStrtX<w)&&(eStrtY>sH-2*w))) {
                                        if(stage.getHeight()-(eY-e.getScreenY())>minH) {
                                            stage.setHeight(stage.getHeight()-(eY-e.getScreenY()));
                                            eY = e.getScreenY();
                                        }
                                        if(stage.getWidth()+(eX-e.getScreenX())>minW) {
                                            stage.setX(e.getScreenX());
                                            stage.setWidth(stage.getWidth()+(eX-e.getScreenX()));
                                            eX = e.getScreenX();
                                        }
                                    }
                                }
                            });
                        }
                        else
                            if(Y<w) {
                                scene.setCursor(Cursor.V_RESIZE);
                                eY = stage.getY();
                                eX = stage.getX() + stage.getWidth();
                                root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent e) {
                                        if((eStrtY<w)&&(stage.getHeight()+(eY-e.getScreenY())>minH)) {
                                            stage.setY(e.getScreenY());
                                            stage.setHeight(stage.getHeight()+(eY-e.getScreenY()));
                                            eY = e.getScreenY();
                                        }
                                    }
                                });
                            }
                            else
                                if(Y>sH-w) {
                                    scene.setCursor(Cursor.V_RESIZE);
                                    eY = stage.getY() + stage.getHeight();
                                    root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                                        @Override
                                        public void handle(MouseEvent e) {
                                            if((eStrtY>sH-w)&&(stage.getHeight()-(eY-e.getScreenY())>minH)) {
                                                stage.setHeight(stage.getHeight()-(eY-e.getScreenY()));
                                                eY = e.getScreenY();
                                            }
                                        }
                                    });
                                }
                                else
                                    if(X<w) {
                                        scene.setCursor(Cursor.H_RESIZE);
                                        eX = stage.getX();
                                        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                                            @Override
                                            public void handle(MouseEvent e) {
                                                if((eStrtX<w)&&(stage.getWidth()+(eX-e.getScreenX())>minW)) {
                                                        stage.setX(e.getScreenX());
                                                        stage.setWidth(stage.getWidth()+(eX-e.getScreenX()));
                                                        eX = e.getScreenX();
                                                }
                                            }
                                        });
                                    }
                                    else
                                        if(X>sW-w) {
                                            scene.setCursor(Cursor.H_RESIZE);
                                            eX = stage.getX() + stage.getWidth();
                                            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                                                @Override
                                                public void handle(MouseEvent e) {
                                                    if((eStrtX>sW-w)&&(stage.getWidth()-(eX-e.getScreenX())>minW)) {
                                                        stage.setWidth(stage.getWidth()-(eX-e.getScreenX()));
                                                        eX = e.getScreenX();
                                                    }
                                                }
                                            });
                                        }
                                        else
                                            if((X>w)&&(X<sW-w)&&(Y>w)&&(Y<25)) {
                                                root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                                                    @Override
                                                    public void handle(MouseEvent e) {
                                                        if((eStrtX>w)&&(eStrtX<sW-w-25*3)&&(eStrtY>w)&&(eStrtY<w+25)) {
                                                            stage.setX(e.getScreenX()-sceneStrtX);
                                                            stage.setY(e.getScreenY()-sceneStrtY);
                                                        }
                                                    }
                                                });
                                            }
                                            else
                                                scene.setCursor(Cursor.DEFAULT);
        }   
    });

    root.setOnMouseReleased(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            eY = e.getScreenY();
            eX = e.getScreenX();
        }
    });
}