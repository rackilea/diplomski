protected final StyleFactory styleFactory =
  CommonFactoryFinder.getStyleFactory(GeoTools.getDefaultHints());
protected final FilterFactory2 filterFactory =
  CommonFactoryFinder.getFilterFactory2();

protected Rule createLayerRule
  ( Color outlineColor
  , float strokeWidth
  , Color fillColor
  , float opacity
  , Filter filter
  , double minScaleDenominator
  , double maxScaleDenominator)
{
  Stroke stroke =
      outlineColor != null
    ? styleFactory.createStroke
       ( filterFactory.literal(outlineColor)
       , filterFactory.literal(strokeWidth)
       , filterFactory.literal(opacity))
    : null;//Stroke.NULL;
  Fill fill = 
      fillColor != null 
    ? styleFactory.createFill
       ( filterFactory.literal(fillColor)
       , filterFactory.literal(opacity))
    : null;//Fill.NULL;

  PolygonSymbolizer symbolizer = 
    styleFactory.createPolygonSymbolizer(stroke, fill, null);

  return createRule(filter, minScaleDenominator, maxScaleDenominator, symbolizer);
}

// IDs of visible features, programmatically updated. 
protected final Set<FeatureId> visibleFeatureIDs = new HashSet<FeatureId>();

// IDs of selected features, programmatically updated. 
protected final Set<FeatureId> selectedFeatureIDs = new HashSet<FeatureId>();

protected Style createLayerStyle()
{
  Filter selectionFilter = filterFactory.id(selectedFeatureIDs);
  Filter visibilityFilter = filterFactory.and
    ( Arrays.asList
        ( filterFactory.not
            (selectionFilter)
        , filterFactory.id(visibleFeatureIDs)
        )
    );
  FeatureTypeStyle fts = styleFactory.createFeatureTypeStyle
    ( new Rule[]
      {
        // hope constants below are self explaining
        createLayerRule
          ( SELECTED_OUTLINE_COLOR 
          , STROKE_WIDTH_LARGE_SCALE
          , SELECTED_FILL_COLOR
          , SELECTED_OPACITY
          , selectionFilter
          , STYLE_SCALE_LIMIT
          , Double.NaN)
      , createLayerRule
          ( UNSELECTED_OUTLINE_COLOR
          , STROKE_WIDTH_LARGE_SCALE
          , UNSELECTED_FILL_COLOR
          , UNSELECTED_OPACITY
          , visibilityFilter
          , STYLE_SCALE_LIMIT
          , Double.NaN)
      , createLayerRule
          ( SELECTED_OUTLINE_COLOR
          , STROKE_WIDTH_SMALL_SCALE
          , SELECTED_FILL_COLOR
          , SELECTED_OPACITY
          , selectionFilter
          , Double.NaN
          , STYLE_SCALE_LIMIT)
      , createLayerRule
          ( UNSELECTED_OUTLINE_COLOR
          , STROKE_WIDTH_SMALL_SCALE
          , UNSELECTED_FILL_COLOR
          , UNSELECTED_OPACITY
          , visibilityFilter
          , Double.NaN
          , STYLE_SCALE_LIMIT)
      }
    );

  Style style = styleFactory.createStyle();
  style.featureTypeStyles().add(fts);

  return style;
}

// layer creation
FeatureLayer someMethode()
{
  ...
  FeatureLayer layer = new FeatureLayer
    ( dataStore.getFeatureSource()
    , createLayerStyle()
    , "Zipcodes"
    );
  ...
  return layer;
}

// style update if visible or selected features have changed
void someOtherMethod(FeatureLayer layer)
{
   ... // update selectedFeatureIDs or visibleFeatureIDs
   layer.setStyle(createLayerStyle());
}