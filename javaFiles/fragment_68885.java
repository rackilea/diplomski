migLayout.addLayoutCallback(new LayoutCallback() {

        /**
         * This is run before the layout starts laying out
         */
        @Override
        public BoundSize[] getSize(ComponentWrapper comp) {
            if(comp.getComponent() instanceof DCMImageWrapper) {
                DCMImageWrapper img=(DCMImageWrapper) comp.getComponent();    //this is the BufferedImage embedded in a JLabel
                int calculatedHeight=img.getHeightFor(comp.getWidth());
                UnitValue maxHeight=new UnitValue(calculatedHeight);
                BoundSize height=new BoundSize(maxHeight, maxHeight, maxHeight, null);

                return new BoundSize[]{null, height};
            } else {
                return null;
            }
        }

        private double getCurrentAspect(ComponentWrapper comp) {
            if(comp.getWidth()==0 || comp.getHeight()==0) return 0;
            double currentAspect=comp.getWidth()/(double)comp.getHeight();
            return currentAspect;
        }

        /**
         * Check if the aspect still valid
         */
        @Override
        public void correctBounds(ComponentWrapper comp) {
            if(comp.getComponent() instanceof DCMImageWrapper) {
                DCMImageWrapper img=(DCMImageWrapper) comp.getComponent();

                double currentAspect=getCurrentAspect(comp);
                double origAspect=img.getDCMImage().getAspect();
                double currentError=Math.abs(origAspect-currentAspect);
                if(currentError > img.getDCMImage().getAspectError()) {
                    //recalculate layout
                    revalidate();
                }
            }
        }

    });