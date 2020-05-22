...
JButton jb = new JButton('Download Button');
jb.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Download file
        URL url = new URL('www.example.com/example_file.jpg');
        File f = new File('...');
        org.apache.commons.io.FileUtils.copyURLToFile(url, f);
    }
});
...