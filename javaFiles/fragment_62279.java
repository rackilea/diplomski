public class BackgroundWorker extends SwingWorker<Object, File> {

    private JTextArea textArea;

    public BackgroundWorker(JTextArea textArea) {

        this.textArea = textArea;

    }

    @Override
    protected Object doInBackground() throws Exception {

        list(new File("C:\\"), 0);

        return null;

    }

    @Override
    protected void process(List<File> chunks) {

        for (File file : chunks) {

            textArea.append(file.getPath() + "\n");

        }

        textArea.setCaretPosition(textArea.getText().length() - 1);

    }

    protected void list(File path, int level) {

        if (level < 4) {

            System.out.println(level + " - Listing " + path);

            File[] files = path.listFiles(new FileFilter() {

                @Override
                public boolean accept(File pathname) {

                    return pathname.isFile();

                }
            });

            publish(path);
            for (File file : files) {

                System.out.println(file);
                publish(file);

            }

            files = path.listFiles(new FileFilter() {

                @Override
                public boolean accept(File pathname) {

                    return pathname.isDirectory() && !pathname.isHidden();

                }
            });

            for (File folder : files) {

                list(folder, level + 1);

            }

        }

    }

}