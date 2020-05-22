pic.addComponentListener(new ComponentListener() {

            @Override
            public void componentResized(ComponentEvent e) {
                //==================== Variables Panel ====================
                int panelWidthAndHight = (Integer) ((Math.round(window.getHeight() / 2)) - 2);

                int textWidth = (Integer) ((Math.round(window.getHeight() / 2)) - 75);
                int textHeight = 23;

                int location1 = (Integer) ((Math.round(window.getHeight() / 2)));
                int location2 = (Integer) (Math.round(window.getHeight()));

                int picWidth = (Integer) (Math.round(window.getWidth() - (window.getHeight()) - 2));
                int picHeight = (Integer) (Math.round(window.getHeight() - 3));
                //====================      End    ====================

                //==================== First Panel ====================
                panel.setSize(new Dimension(panelWidthAndHight, panelWidthAndHight));
                panel.setLocation(1, 1);

                amountText1.setSize(new Dimension(textWidth, textHeight));
                LittreText1.setSize(new Dimension(textWidth, textHeight));
                //====================      End    ====================

                //==================== Second Panel ====================
                panel2.setSize(new Dimension(panelWidthAndHight, panelWidthAndHight));
                panel2.setLocation(location1, 1);

                amountText2.setSize(new Dimension(textWidth, textHeight));
                LittreText2.setSize(new Dimension(textWidth, textHeight));
                //====================      End    ====================

                //==================== Third Panel ====================
                panel3.setSize(new Dimension(panelWidthAndHight, panelWidthAndHight - 40));
                panel3.setLocation(1, location1);

                amountText3.setSize(new Dimension(textWidth, textHeight));
                LittreText3.setSize(new Dimension(textWidth, textHeight));
                //====================      End    ====================

                //==================== Third Panel ====================
                panel4.setSize(new Dimension(panelWidthAndHight, panelWidthAndHight - 40));
                panel4.setLocation(location1, location1);

                amountText4.setSize(new Dimension(textWidth, textHeight));
                LittreText4.setSize(new Dimension(textWidth, textHeight));
                //====================      End    ====================

                panel5.setSize(new Dimension(picWidth, picHeight));

                pic.setLocation(xy[0], xy[1]);

                window.invalidate();
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void componentShown(ComponentEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }
        });