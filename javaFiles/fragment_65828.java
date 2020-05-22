public class MyEditorKit extends HTMLEditorKit {

    private static final int MIN_HEIGHT_VIEWS = 10;

    @Override
    public ViewFactory getViewFactory() {

        return new HTMLFactory() {

            @Override
            public View create(Element e) {
                View v = super.create(e);
                // Test for BRView must use String comparison, as the class is package-visible and not available to us
                if ((v instanceof InlineView) && !v.getClass().getSimpleName().equals("BRView")) {

                    View v2 = new InlineView(e) {

                        @Override
                        public float getMaximumSpan(int axis) {
                            float result = super.getMaximumSpan(axis);
                            if (axis == Y_AXIS) {
                                result = Math.max(result, MIN_HEIGHT_VIEWS);
                            }
                            return result;
                        }

                        @Override
                        public float getMinimumSpan(int axis) {
                            float result = super.getMinimumSpan(axis);
                            if (axis == Y_AXIS) {
                                result = Math.max(result, MIN_HEIGHT_VIEWS);
                            }
                            return result;
                        }

                        @Override
                        public float getPreferredSpan(int axis) {
                            float result = super.getPreferredSpan(axis);
                            if (axis == Y_AXIS) {
                                result= Math.max(result, MIN_HEIGHT_VIEWS);
                            }

                            return result;
                        }
                    };

                    v = v2;
                }

                return v;
            }
        };
    }
}