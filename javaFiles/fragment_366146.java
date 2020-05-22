public static void main(String[] args) {
            int windowWidth = 1000;// (int)screenSize.getWidth() - 200;
            int windowHeight = 800;// (int)screenSize.getHeight() - 50;
            int plotWidth = 400;// (int)screenSize.getWidth() - 600;
            int plotHeight = 400;// (int)screenSize.getHeight() - 150;

            JuliaSet cJuliaSet = new JuliaSet("Julia Set", windowWidth, windowHeight, plotWidth, plotHeight);
            cJuliaSet.setVisible(true);
           //While loop removed
        }