@Override public void mouseClicked(MouseEvent e)
        {

                System.out.println(this.postion);
                if (highlightedOne != -1) 
                    myCustomPanels[highlightedOne].setBackground(Color.white);
                highlightedOne = this.position;
                setBackground(Color.black);
        }