public class TilePanel extends JPanel{
    //A JLabel for each tile
    private JLabel theLabel = new JLabel();

TilePanel(int i, int j){
        //constructor add the Label to itself
        this.add(theLabel);


//A function to "setIcon" instead of using .add() multiple times
public void setImage(){
    //assign in an icon
    if (this.pieceAtTile != null){
            BufferedImage img = null;
            try{
                img = ImageIO.read(getClass().getResource(this.pieceAtTile.getImagePath()));
            }catch(IOException e){
                e.printStackTrace();
            }
            ImageIcon icon = new ImageIcon(img);
            this.theLabel.setIcon(icon);
        }
        else{this.theLabel.setIcon(null);}
    theLabel.repaint();
    }