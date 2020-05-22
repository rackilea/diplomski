ByteArrayInputStream bis = new ByteArrayInputStream(clipboardObject.data);
try(ObjectInput in = new ObjectInputStream(bis)) {
        ImageIcon img = (ImageIcon) in.readObject();
        Image original =  img.getImage();

        BufferedImage newImage = new BufferedImage(
                original.getWidth(null), original.getHeight(null), BufferedImage.TYPE_INT_RGB);

        Graphics2D g = newImage.createGraphics();
        g.drawImage(original, 0, 0, null);
        g.dispose();
        ImageTransferable t = new ImageTransferable(newImage);
        Toolkit.getDefaultToolkit().getSystemClipboard()
                .setContents(t, null);
}catch(Exception e)
{
        e.printStackTrace();
}