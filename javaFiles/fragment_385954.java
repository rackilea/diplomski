int length = renderer.getSeriesRendererCount();
        for (int i = 0; i < length; i++) {
            XYSeriesRenderer seriesRenderer = (XYSeriesRenderer) renderer
                    .getSeriesRendererAt(i);                
            seriesRenderer.setLineWidth(2);
        }