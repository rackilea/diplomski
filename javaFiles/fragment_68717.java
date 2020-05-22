public class ImageWorker extends SwingWorker<ImageIcon, Void>{

URL imageURL;
ImageIcon brandImage;
JButton device;

public ImageWorker(URL imageURL, JButton device){
    this.imageURL = imageURL;
    this.device = device;
}

@Override
protected ImageIcon doInBackground() throws Exception {
    brandImage = new ImageIcon(imageURL);
    Image rawBrandImage = brandImage.getImage();
    Image newimg = rawBrandImage.getScaledInstance(32, 32,  java.awt.Image.SCALE_SMOOTH);
    brandImage = new ImageIcon(newimg);
    return brandImage;
}

@Override
protected void done() {
    // leave as default zagg shield icon if no brand icon is returned by api
    if (brandImage.getIconWidth() == 32 && brandImage.getIconHeight() == 32) {
        device.setIcon(brandImage);
    }
  }
}