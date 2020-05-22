import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Mp3TaggerFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JPanel albumArt;
    private JLabel imageArt;
    private JTextField titleTrack;
    private JTextField artist;
    private JTextField album;
    private JTextField genre;
    private JTextField trackNumber;
    private JTextField lenght;
    private JTextField year;
    private JTextField comment;
    private JTextField bitRate;

    public static void main(String[] args) {
        new Mp3TaggerFrame().setVisible(true);
    }

    JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Mp3 File",
            "mp3");

    public void setAlbumArt(BufferedImage _image) {

    }

    public String getTitleTrack() {
        return titleTrack.getText();
    }

    public void setTitleTrack(String title) {
        this.titleTrack.setText(title);
    }

    public String getArtist() {
        return artist.getText();
    }

    public void setArtist(String artist) {
        this.artist.setText(artist);
    }

    public String getAlbum() {
        return album.getText();
    }

    public void setAlbum(String album) {
        this.album.setText(album);
    }

    public String getGenre() {
        return genre.getText();
    }

    public void setGenre(String genre) {
        this.genre.setText(genre);
    }

    public int getTrackNumber() {
        return Integer.valueOf(trackNumber.getText());
    }

    public void setTrackNumber(String string) {
        this.trackNumber.setText(string);
    }

    public void setLenght(int lenght) {
        int min = 0;
        int sec = lenght;
        while (sec >= 60) {
            sec = sec - 60;
            min++;
        }
        this.lenght.setText(String.valueOf(min) + ":" + String.valueOf(sec));
    }

    public int getYear() {
        return Integer.valueOf(year.getText());
    }

    public void setYear(String year) {
        this.year.setText(year);
    }

    public String getComment() {
        return comment.getText();
    }

    public void setComment(String comment) {
        this.comment.setText(comment);
    }

    public String getBitRate() {
        return bitRate.getText();
    }

    public void setBitRate(String bitRate) {
        this.bitRate.setText(bitRate);
    }

    /**
     * Create the frame.
     */
    public Mp3TaggerFrame() {

        chooser.setFileFilter(filter);

        setFont(new Font("Century Schoolbook", Font.PLAIN, 14));
        setResizable(false);
        setTitle("Mp3Tagger");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 562, 423);

        setIconImage(new ImageIcon("res/Icon.png").getImage());

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

        JMenuItem openMp3File = new JMenuItem("Open Mp3 File");
        mnFile.add(openMp3File);
        openMp3File.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });

        JMenuItem saveWithNewTag = new JMenuItem("Save With New Tag");
        mnFile.add(saveWithNewTag);
        saveWithNewTag.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                saveFile();
            }
        });

        JMenuItem mntmExit = new JMenuItem("Exit");
        mnFile.add(mntmExit);

        JMenu mnAbout = new JMenu("About");
        menuBar.add(mnAbout);

        JMenuItem mntmAboutTheProgram = new JMenuItem("About The Program");
        mnAbout.add(mntmAboutTheProgram);

        JMenuItem mntmContacts = new JMenuItem("Contacts");
        mnAbout.add(mntmContacts);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Title:");
        lblTitle.setFont(new Font("DokChampa", Font.PLAIN, 15));
        lblTitle.setBounds(6, 6, 122, 28);
        contentPane.add(lblTitle);

        titleTrack = new JTextField();
        titleTrack.setToolTipText("Title Of The Track");
        titleTrack.setBounds(6, 32, 122, 28);
        contentPane.add(titleTrack);
        titleTrack.setColumns(10);

        JLabel lblArtist = new JLabel("Artist:");
        lblArtist.setFont(new Font("DokChampa", Font.PLAIN, 15));
        lblArtist.setBounds(6, 72, 122, 28);
        contentPane.add(lblArtist);

        artist = new JTextField();
        artist.setToolTipText("Artist");
        artist.setColumns(10);
        artist.setBounds(6, 98, 122, 28);
        contentPane.add(artist);

        JLabel lblAlbum = new JLabel("Album:");
        lblAlbum.setFont(new Font("DokChampa", Font.PLAIN, 15));
        lblAlbum.setBounds(6, 138, 122, 28);
        contentPane.add(lblAlbum);

        album = new JTextField();
        album.setToolTipText("Album");
        album.setColumns(10);
        album.setBounds(6, 164, 122, 28);
        contentPane.add(album);

        JLabel lblGenre = new JLabel("Genre:");
        lblGenre.setFont(new Font("DokChampa", Font.PLAIN, 15));
        lblGenre.setBounds(6, 270, 122, 28);
        contentPane.add(lblGenre);

        genre = new JTextField();
        genre.setToolTipText("Genre Of The Track");
        genre.setColumns(10);
        genre.setBounds(6, 296, 122, 28);
        contentPane.add(genre);

        JLabel lblTrackNumber = new JLabel("Track Number:");
        lblTrackNumber.setFont(new Font("DokChampa", Font.PLAIN, 15));
        lblTrackNumber.setBounds(6, 204, 122, 28);
        contentPane.add(lblTrackNumber);

        trackNumber = new JTextField();
        trackNumber.setToolTipText("Number of the track in the album");
        trackNumber.setColumns(10);
        trackNumber.setBounds(6, 230, 122, 28);
        contentPane.add(trackNumber);

        JLabel lblAlbumArt = new JLabel("Album Art");
        lblAlbumArt.setFont(new Font("DokChampa", Font.PLAIN, 15));
        lblAlbumArt.setBounds(375, 6, 73, 28);
        contentPane.add(lblAlbumArt);

        albumArt = new JPanel();
        BufferedImage bi = new BufferedImage(150,150,BufferedImage.TYPE_INT_RGB);
        albumArt.add(new JLabel(new ImageIcon(bi)));
        albumArt.setToolTipText("The Album Cover");
        albumArt.setBounds(375, 42, 150, 150);
        contentPane.add(albumArt);

        JLabel lblLenght = new JLabel("Lenght");
        lblLenght.setFont(new Font("DokChampa", Font.PLAIN, 15));
        lblLenght.setBounds(375, 204, 122, 28);
        contentPane.add(lblLenght);

        lenght = new JTextField();
        lenght.setEditable(false);
        lenght.setToolTipText("Lenght of the song");
        lenght.setColumns(10);
        lenght.setBounds(375, 230, 122, 28);
        contentPane.add(lenght);

        JButton editAlbumArt = new JButton("Edit");
        editAlbumArt.setBounds(460, 6, 55, 28);
        contentPane.add(editAlbumArt);

        JLabel lblYear = new JLabel("Year:");
        lblYear.setFont(new Font("DokChampa", Font.PLAIN, 15));
        lblYear.setBounds(181, 6, 122, 28);
        contentPane.add(lblYear);

        year = new JTextField();
        year.setToolTipText("Year Of The Track");
        year.setColumns(10);
        year.setBounds(181, 32, 122, 28);
        contentPane.add(year);

        JLabel lblComments = new JLabel("Comments:");
        lblComments.setFont(new Font("DokChampa", Font.PLAIN, 15));
        lblComments.setBounds(181, 72, 122, 28);
        contentPane.add(lblComments);

        comment = new JTextField();
        comment.setToolTipText("Comments Of The Track");
        comment.setColumns(10);
        comment.setBounds(181, 98, 122, 160);
        contentPane.add(comment);

        JLabel lblBitrate = new JLabel("Bit Rate");
        lblBitrate.setFont(new Font("DokChampa", Font.PLAIN, 15));
        lblBitrate.setBounds(375, 270, 122, 28);
        contentPane.add(lblBitrate);

        bitRate = new JTextField();
        bitRate.setToolTipText("BitRate of the song");
        bitRate.setEditable(false);
        bitRate.setColumns(10);
        bitRate.setBounds(375, 296, 122, 28);
        contentPane.add(bitRate);
    }

    private void openFile() {
    }

    private void setTextFields() {
    }

    private void saveFile() {
    }
}