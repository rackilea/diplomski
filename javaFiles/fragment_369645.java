private class MyActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn) {
            for(int i= 0; i< row; i++) {
                for (int j= 0 ; j < col ; j++) {
                    matrix.getCell(i,j).setBackground(Color.white);
                }
            }
        } else {
            for(int i= 0; i< row; i++) {
                for (int j= 0 ;j<col ; j++) {
                    if(e.getSource()== matrix.getCell(i,j)) {
                        if(matrix.getCell(i,j).getBackground()== Color.white)
                            matrix.getCell(i,j).setBackground(Color.black);
                        else
                            matrix.getCell(i,j).setBackground(Color.white);
                    }
                }
            }
        }
    }
}