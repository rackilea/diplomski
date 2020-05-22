mxGraphComponent graphComponent = new mxGraphComponent(graph){
public mxInteractiveCanvas createCanvas()
    {
        return new mxInteractiveCanvas(){
            @Override
            public Object drawLabel(String text, mxCellState state, boolean html)
            {
                Map<String, Object> style = state.getStyle();
                mxIShape shapeL = getShape(style);
                mxITextShape shape = getTextShape(style, html);
                if (g != null && shape != null && drawLabels && text != null
                        && text.length() > 0)
                {
                    // Creates a temporary graphics instance for drawing this shape
                    float opacity = mxUtils.getFloat(style,
                            mxConstants.STYLE_TEXT_OPACITY, 100);
                    Graphics2D previousGraphics = g;
                    if(((mxCell) state.getCell()).isVertex()){
                        g = createTemporaryGraphics(style, opacity, null);                                  
                    }else{
                        //quadrant will be true if the edge is NE or SW
                        Object target = ((mxCell) state.getCell()).getTarget();
                        Object source = ((mxCell) state.getCell()).getSource();
                        boolean quadrant = false;
                        if(((mxCell)target).getGeometry().getCenterX()<((mxCell)source).getGeometry().getCenterX()){
                            if(((mxCell)target).getGeometry().getCenterY()>((mxCell)source).getGeometry().getCenterY()){
                                quadrant =  true;
                            }
                        }
                        if(((mxCell)target).getGeometry().getCenterX()>((mxCell)source).getGeometry().getCenterX()){
                            if(((mxCell)target).getGeometry().getCenterY()<((mxCell)source).getGeometry().getCenterY()){
                                quadrant =  true;
                            }
                        }
                        g = createTemporaryGraphics(style, opacity, state, state.getLabelBounds(),quadrant);
                    }

                    // Draws the label background and border
                    Color bg = mxUtils.getColor(style,
                            mxConstants.STYLE_LABEL_BACKGROUNDCOLOR);
                    Color border = mxUtils.getColor(style,
                            mxConstants.STYLE_LABEL_BORDERCOLOR);
                    paintRectangle(state.getLabelBounds().getRectangle(), bg, border);

                    // Paints the label and restores the graphics object
                    shape.paintShape(this, text, state, style);
                    g.dispose();
                    g = previousGraphics;
                }

                return shape;
            }
            public Graphics2D createTemporaryGraphics(Map<String, Object> style,
                    float opacity, mxRectangle bounds, mxRectangle labelbounds, boolean quad)
            {
                Graphics2D temporaryGraphics = (Graphics2D) g.create();

                // Applies the default translate
                temporaryGraphics.translate(translate.x, translate.y);

                // setup the rotation for the label
                double angle = java.lang.Math.atan(bounds.getHeight()/bounds.getWidth());
                double rotation = Math.toDegrees(angle);
                if(quad){
                    rotation = - rotation;
                }
                //get the translation needed
                double diff = labelbounds.getHeight()*(1-Math.cos(angle));
                double plusy = diff * Math.sin(angle);
                double plusx = diff * Math.cos(angle);
                // Applies the rotation and translation on the graphics object
                if (bounds != null)
                {
                    if (rotation != 0)
                    {
                        temporaryGraphics.rotate(Math.toRadians(rotation),
                                labelbounds.getCenterX(), labelbounds.getCenterY());
                        temporaryGraphics.translate(
                                - plusx, plusy);
                    }
                }

                // Applies the opacity to the graphics object
                if (opacity != 100)
                {
                    temporaryGraphics.setComposite(AlphaComposite.getInstance(
                            AlphaComposite.SRC_OVER, opacity / 100));
                }

                return temporaryGraphics;
            }
        };
    }

};