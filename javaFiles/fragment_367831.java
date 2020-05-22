Panel drawingpanel = new Panel() {
        public void paint(Graphics g) {
            if (dot == null) {
                return;
            }
            g.drawOval(dot.leftOf(), dot.topOf(), dot.widthOf(), dot.heightOf());
            g.fillOval(dot.leftOf(), dot.topOf(), dot.widthOf(), dot.heightOf());
        };
    };