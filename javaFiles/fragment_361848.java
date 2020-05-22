// Handler option for circle
RegularPolygonHandlerOptions handlerOptions = new RegularPolygonHandlerOptions();
// 30 side is ok for a circle
handlerOptions.setSides(30);
handlerOptions.setSnapAngle(0);
handlerOptions.setIrregular(false);

// Add the handler option to the DrawFeatureOptions
drawFeatureOptions.setHandlerOptions(handlerOptions);

// create the draw feature control
DrawFeature drawCircleFeatureControl = new DrawFeature(geometryFeaturesLayer, new RegularPolygonHandler(),
        drawFeatureOptions);

// Add the control to the map
map.addControl(drawCircleFeatureControl);