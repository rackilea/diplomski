class Window ... 
{
    // Store this as an instance variable
    private JPanel mediaPanel;


    private JPanel buildShelfs()
    {
        mediaPanel = new JPanel();
        mediaPanel.setOpaque(false);
        mediaPanel.setLayout(new GridLayout(3, 6, 22, 30));
        mediaPanel.setBounds(90, 25, 1020, 745);
        for (int i=0; i<18; i++)
        {
            addMedia(i);
        }
        return mediaPanel;
    }


    private void addMedia(int index)
    {
        // You should store these images LOCALLY!!!
        String urlString = "https://dl.dropboxusercontent.com/u/16670644/Projekt/TempPic.png";

        int nrOfMedias = myMediaHandler.mediaList.size();
        if (index < nrOfMedias)
        {
            urlString = myMediaHandler.mediaList.get(i).getImagePath();
        }
        addMedia(urlString);
    }

    void addMedia(String urlString)
    {
        try
        {
            java.net.URL where = new URL(urlString);
            ImageIcon image = new ImageIcon(where);
            JLabel imageLabel = new JLabel(image);
            mediaPanel.add(imageLabel);
            mediaPanel.invalidate();
            mediaPanel.validate();
        }
        catch (MalformedURLException e)
        {
            System.out.println("Error loading user media picture from "+urlString);
            e.printStackTrace();
        }
    }

}




class MediaHandler 
{
    ArrayList<Media> mediaList;

    private Window myWindow;

    public MediaHandler(Window window) 
    {
        this.mediaList = new ArrayList<Media>();
        myWindow = window;
    }

    public void addMovie(String title, Double playTime, int year,
        String directory, String mediaPath, String imagePath, String quality,
        boolean subtitles, String language, String writer) 
    {
        mediaList.add(new Movie(title, playTime, year, 
            false, directory, mediaPath, imagePath, rating.unrated, 
            quality, subtitles, language, writer));

        myWindow.addMedia(mediaPath);
    }   
}