public void start(Stage stage) {
                (do your stuff)
      pane.setOnMouseClicked(mouseHandler);
        pane.setOnMouseDragged(mouseHandler);
        pane.setOnMouseEntered(mouseHandler);
        pane.setOnMouseExited(mouseHandler);
        pane.setOnMouseMoved(mouseHandler);
        pane.setOnMousePressed(mouseHandler);
        pane.setOnMouseReleased(mouseHandler);
}


1. In mouseDrag Event you take Xaxiz and Yaxis  

2.In mouseRelease Event you can Change in
Lowerbound and upperbound value in to the chart


 EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
        //Tooltip tooltip = new Tooltip();
        final ObjectProperty<Point2D> mouseAnchor = new SimpleObjectProperty<>();

        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED) {
                    rect.setX(mouseEvent.getX());
                    rect.setY(mouseEvent.getY());
                    rectinitX.set(mouseEvent.getX());
                    rectinitY.set(mouseEvent.getY());
                    System.out.println("rect:" + rect);
                    mouseAnchor.set(new Point2D(mouseEvent.getX(), mouseEvent.getY()));
                    System.out.println("mouseEvent X: " + mouseEvent.getSceneX());
                    System.out.println("mouseEvent y: " + mouseEvent.getSceneY());
                    System.out.println("mouseAnchor : " + mouseAnchor);
                    //  MAX_DATA_POINTS = 100;
                    //  MAX_DATA_POINTS_LOWER = 1;
                    //  tooltip();
                } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                    rectX.set(mouseEvent.getX());
                    rectY.set(mouseEvent.getY());
                    rect.setX(Math.min(mouseEvent.getX(), mouseAnchor.get().getX()));
                    rect.setY(Math.min(mouseEvent.getY(), mouseAnchor.get().getY()));
//            rect.setWidth(Math.abs(mouseEvent.getX() - mouseAnchor.get().getX()));
//            rect.setHeight(Math.abs(mouseEvent.getY() - mouseAnchor.get().getY()));
                    System.out.println("  MOUSE_DRAGGED ");
                } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED) {
                    System.out.println("  MOUSE_RELEASED ");
                    if ((rectinitX.get() >= rectX.get()) && (rectinitY.get() >= rectY.get())) {
                        //Condizioni Iniziali
                        LineChart lineChart = lineChart2;

                        // ((CategoryAxis) lineChart.getXAxis()).setLowerBound(initXLowerBound);
                        //((CategoryAxis) lineChart.getXAxis()).setUpperBound(initXUpperBound);
                        ((NumberAxis) lineChart.getYAxis()).setLowerBound(initYLowerBound);
                        ((NumberAxis) lineChart.getYAxis()).setUpperBound(initYUpperBound);
                        System.out.println("  Inside IF ");

                    } else {
                        //Zoom In
                        System.out.println("  Inside else ");

                        double Tgap = 0, Tgap1 = 0;
                        double newLowerBound, newUpperBound, axisShift, axisShifX, newXlower, newXupper;
                        double xScaleFactor, yScaleFactor;
                        double xaxisShift, yaxisShift;
                        LineChart lineChart = lineChart2;

                        // Zoom in Y-axis by changing bound range.            
                        NumberAxis yAxis = (NumberAxis) lineChart.getYAxis();
                        NumberAxis xAxis = (NumberAxis) lineChart.getXAxis();
                        System.out.println("X " + xAxis + " Y " + yAxis);
                        Tgap = yAxis.getHeight() / (yAxis.getUpperBound() - yAxis.getLowerBound());

                        // Tgap1 = xAxis.getHeight()/(xAxis.getUpperBound() - xAxis.getLowerBound());
                        axisShift = getSceneShiftY(yAxis);
                        yaxisShift = axisShift;
                        xaxisShift = getSceneShiftX(xAxis);
                        System.out.println("yAxisUPPER:" + yAxis.getUpperBound() + "yAxisLOWER:" + yAxis.getLowerBound());
                        newUpperBound = yAxis.getUpperBound() - ((rectinitY.get() - axisShift) / Tgap);
                        newLowerBound = yAxis.getUpperBound() - ((rectY.get() - axisShift) / Tgap);

                        if (newUpperBound > yAxis.getUpperBound()) {
                            newUpperBound = yAxis.getUpperBound();
                        }

                        yScaleFactor = (yAxis.getUpperBound() - yAxis.getLowerBound()) / (newUpperBound - newLowerBound);

                        System.out.println("newLowerBound " + newLowerBound + "newUpperBound " + newUpperBound);
                        yAxis.setLowerBound(newLowerBound);
                        yAxis.setUpperBound(newUpperBound);

                        Tgap1 = xAxis.getWidth() / (xAxis.getUpperBound() - xAxis.getLowerBound());

                        newXlower = ((rectinitX.get() - xaxisShift) / Tgap1) + xAxis.getLowerBound();
                        newXupper = ((rectX.get() - xaxisShift) / Tgap1) + xAxis.getLowerBound();
                        System.out.println("newLowerBoundX " + newXlower + "newUpperBoundX " + newXupper);
                        if (newXupper > xAxis.getUpperBound()) {
                            newXupper = xAxis.getUpperBound();
                        }

                        xAxis.setLowerBound(newXlower);
                        MAX_DATA_POINTS_LOWER = (int) newXlower;
                        MAX_DATA_POINTS = (int) newXupper;
                        xAxis.setUpperBound(newXupper);

                    }
                    // Hide the rectangle
                    rectX.set(0);
                    rectY.set(0);
                } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_MOVED) {
                    System.out.println(" MOUSE_MOVED " + mouseEvent.getX() + " " + mouseEvent.getY());
//              Tooltip.install(series.getNode(), new Tooltip(
//                        mouseEvent.getX() + "\n" +
//                                "Number Of Events : " + mouseEvent.getY())); 
                }
            } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                System.out.println("  SECONDARY ");
                MAX_DATA_POINTS = 100;
                MAX_DATA_POINTS_LOWER = 1;
            }// end if (mouseEvent.getButton() == MouseButton.PRIMARY)
            else if (mouseEvent.getButton() == MouseButton.NONE) {
                System.out.println(" NONE " + mouseEvent.getX() + " " + mouseEvent.getY());

            }
        }
    };