setLayout(new LayoutManager() {
        @Override
        public void addLayoutComponent(String name, Component comp) {



        }

        @Override
        public void removeLayoutComponent(Component comp) {

        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            return null;
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return null;
        }

        @Override
        public void layoutContainer(Container parent) {

        public void layoutContainer(Container parent) {

            float modifierx = Toolkit.getDefaultToolkit().getScreenSize().width/100;

            float Sizemodifier = Toolkit.getDefaultToolkit().getScreenSize().height/50;

            float modifiery = Toolkit.getDefaultToolkit().getScreenSize().height/150;

            int x=(int)(Toolkit.getDefaultToolkit().getScreenSize().width/modifierx);

            int y=(int)(Toolkit.getDefaultToolkit().getScreenSize().height/modifiery);

            int height =(int)(Toolkit.getDefaultToolkit().getScreenSize().height/Sizemodifier);

            int DX =(int)(Toolkit.getDefaultToolkit().getScreenSize().width/modifierx);

            int DY =(int)(Toolkit.getDefaultToolkit().getScreenSize().height/modifiery);

            for(int i = 0; i<parent.getComponentCount();i++){

                if(i%2==0){

                    parent.getComponent(i).setBounds(x,y,x,height);

                    x+= DX;

                }else{

                    parent.getComponent(i).setBounds(x,y,x,height);

                    x=Toolkit.getDefaultToolkit().getScreenSize().width/100;

                    y+=DY;

                }

            }
        }


    });