public class Data2DFrame extends JFrame{
    public Data2DFrame(Data2D data2D,double min,double max,Data2DColorMap data2DColorMap) {    
        // Set image if data is nonempty
        if (data2D.height > 0 && data2D.width > 0) {
            // Set data panel
            Data2DPanel data2DPanel = new Data2DPanel(data2D,min,max,data2DColorMap);
            data2DPanel.toggleKeyBoard(); // Allow keyboard interaction
            data2DPanel.toggleMouse();    // Allow mouse interaction
            // data2DPanel.setPreferredSize(new Dimension(data2D.width,data2D.height));

            // Set colorbar
            Data2DColorBar data2DColorBar = new Data2DColorBar(min,max,data2DColorMap);
            // data2DColorBar.setPreferredSize(new Dimension(100,data2D.height));

            // Arrange
            this.setLayout(new BorderLayout());
            this.add(data2DPanel,BorderLayout.CENTER);
            this.add(data2DColorBar,BorderLayout.LINE_END);
            this.pack();
        }        
    }
}