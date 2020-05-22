package testingThings;

    import java.awt.Desktop;
    import java.io.IOException;
    import java.nio.file.Files;
    import java.nio.file.Path;
    import java.nio.file.Paths;
    import java.text.SimpleDateFormat;
    import java.util.Arrays;
    import java.util.Calendar;
    import java.util.Date;

    import javax.swing.JFileChooser;
    import javax.swing.JOptionPane;
    import javax.swing.filechooser.FileNameExtensionFilter;

    public class FileHandler {

        public Path choose() {
            JFileChooser choose = new JFileChooser();
            choose.setFileFilter(new FileNameExtensionFilter("PDF and JPG", "pdf", "jpg"));
            choose.showOpenDialog(null);

            Path sourcePath = choose.getSelectedFile().toPath();

            return sourcePath;
        }

        public void move(Path sourcePath, Path destinationPath) {
            try {
                Files.move(
                        sourcePath, 
                        destinationPath//, 
                        // since the destinationPath is unique, do not replace
    //                  StandardCopyOption.REPLACE_EXISTING,
                        // works for moving file on the same drive 
                        //its basically a renaming of path
    //                  StandardCopyOption.ATOMIC_MOVE
                );
    //          JOptionPane.showMessageDialog(null, "file " + sourcePath.getFileName() + " moved");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                JOptionPane.showMessageDialog(
                        null, 
                        "moving failed for file: " + sourcePath.getFileName(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                e.printStackTrace();
                System.exit(1);
            }
        }

        public void open(Path destinationPath) {
            try {
                Desktop.getDesktop().open(destinationPath.toFile());
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(
                        null, 
                        "file openning fails: " + destinationPath.getFileName(), 
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                System.exit(1);
            }
        }

        public static void main(String[] args) {
            FileHandler fileHandler = new FileHandler();
            Path sourcePath = fileHandler.choose();

            String extension = fileHandler.getFileExtension(sourcePath);
            Path destinationPath = fileHandler.generateDestinationPath(extension);

            fileHandler.move(sourcePath, destinationPath);
            fileHandler.open(destinationPath);
        }

        /**
        * Generate a path for a file with given extension.
        * The Path ist hardcoded to the folder "D:\\documents\\". The filename is the current date with appended index. For Example: 
        * <ul>
        *   <li>D:\\documents\\2016-11-19__12-13-43__0.pdf</li>
        *   <li>D:\\documents\\2016-11-19__12-13-43__1.pdf</li>
        *   <li>D:\\documents\\2016-11-19__12-13-45__0.jpg</li>
        * </ul>
        * @param extension 
        * @return
        */
        public Path generateDestinationPath(String extension) {
            Date today = Calendar.getInstance().getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd__HH-mm-ss");

            String filename;
            Path destinationPath;
            int index = 0;

            do {
                filename = sdf.format(today) + "__" + index + "." + extension;
                destinationPath = Paths.get("D:\\documents\\" + filename);
                destinationPath = Paths.get("C:\\Users\\ceo\\AppData\\Local\\Temp\\" + filename);
                System.out.println(destinationPath);
                index++;
            }
            while (destinationPath.toFile().exists());

            return destinationPath;
        }

        /**
        * Return the String after the last dot
        * @param path
        * @return String
        */
        public String getFileExtension(Path path) {
            String[] parts = path.toString().split("\\.");
            System.out.println(path);
            System.out.println(Arrays.toString(parts));
            System.out.println(parts.length);

            String extension = parts[parts.length - 1];
            return extension;
        }
    }