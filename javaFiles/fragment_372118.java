ArrayList<JPanel> jpanels = new ArrayList<JPanel>();

            for(Component c : fc.getComponents()){
                if( c instanceof JPanel ){
                    jpanels.add((JPanel)c);
                }
            }

            jpanels.get(0).getComponent(0).setVisible(false);

            frame.pack();