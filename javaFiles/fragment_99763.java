import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import javax.swing.*;

@SuppressWarnings("serial")
public class GuiLongRunning extends JPanel {
    public static final int IMG_W = 800;
    public static final int IMG_H = 500;
    BufferedImage blankImage = new BufferedImage(IMG_W, IMG_H, BufferedImage.TYPE_INT_ARGB);
    private Icon blankIcon = new ImageIcon(blankImage);
    private JLabel imageLabel = new JLabel(blankIcon);
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JDialog runningDialog = null;

    public GuiLongRunning() {
        JPanel topPanel = new JPanel();
        for (ImageType imageType : ImageType.values()) {
            JRadioButton radioButton = new JRadioButton(imageType.getName());
            radioButton.addItemListener(new RadioItemListener(imageType));
            topPanel.add(radioButton);
            buttonGroup.add(radioButton);
            int mnemonic = imageType.getName().charAt(0);
            radioButton.setMnemonic(mnemonic);
        }

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.PAGE_START);
        add(imageLabel, BorderLayout.CENTER);
    }

    public void workerRunning(boolean running) {
        if (!running) {
            if (runningDialog != null) {
                runningDialog.dispose();
            }
        } else {
            if (runningDialog == null) {
                JProgressBar progressBar = new JProgressBar();
                progressBar.setPreferredSize(new Dimension(300, 30));
                progressBar.setIndeterminate(true);
                Window thisWindow = SwingUtilities.getWindowAncestor(GuiLongRunning.this);
                runningDialog = new JDialog(thisWindow, "Creating Image", ModalityType.APPLICATION_MODAL);
                runningDialog.add(progressBar);
                runningDialog.pack();
                runningDialog.setLocationRelativeTo(thisWindow);
            }
            runningDialog.setVisible(true);
        }
    }

    private class RadioItemListener implements ItemListener {
        private ImageType imageType;

        public RadioItemListener(ImageType imageType) {
            this.imageType = imageType;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                int w = GuiLongRunning.IMG_W;
                int h = GuiLongRunning.IMG_H;
                ProcessImageWorker worker = new ProcessImageWorker(imageType, w, h);
                worker.addPropertyChangeListener(new WorkerListener());
                worker.execute();
                workerRunning(true);
            }
        }
    }

    private class WorkerListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (SwingWorker.StateValue.DONE == evt.getNewValue()) {
                ProcessImageWorker worker = (ProcessImageWorker) evt.getSource();
                try {
                    Icon icon = worker.get();
                    imageLabel.setIcon(icon);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
                // delay it a little so won't call this before the dialog is
                // visible
                SwingUtilities.invokeLater(() -> workerRunning(false));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui() {
        GuiLongRunning mainPanel = new GuiLongRunning();
        JFrame frame = new JFrame("GuiLongRunning");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}

class ProcessImageWorker extends SwingWorker<Icon, Void> {
    private static final float DELTA_H = 0.01f;
    private static final long SLEEP_TIME = 1500;
    private ImageType imageType;
    private int width;
    private int height;
    private Random random = new Random();

    public ProcessImageWorker(ImageType imageType, int width, int height) {
        this.imageType = imageType;
        this.width = width;
        this.height = height;
    }

    @Override
    protected Icon doInBackground() throws Exception {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Raster raster = img.getData();
        DataBufferInt dataBuffer = (DataBufferInt) raster.getDataBuffer();
        int[][] data = dataBuffer.getBankData();

        if (imageType == ImageType.RAW) {
            rawProcess(data);
        } else if (imageType == ImageType.PREPROCESSED) {
            colorProcess(data);
        }
        img.setData(raster);
        Thread.sleep(SLEEP_TIME); // !! 

        return new ImageIcon(img);
    }

    private int[][] rawProcess(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                int randInt = (int) (256 * Math.random());
                data[i][j] = new Color(randInt, randInt, randInt).getRGB();
            }
        }
        return data;
    }

    // some random colors
    private int[][] colorProcess(int[][] data) {
        float h = 0f;
        for (int i = 0; i < data.length; i++) {
            float h2 = h;
            for (int j = 0; j < data[i].length; j++) {
                h2 += DELTA_H * random.nextFloat();
                h2 += 1f;
                h2 %= 1f;

                Color c = Color.getHSBColor(h2, 1f, 1f);
                int randInt = c.getRGB();
                data[i][j] = randInt;
            }
        }
        return data;
    }
}

enum ImageType {
    RAW("Raw"), PREPROCESSED("Preprocessed");
    private String name;

    private ImageType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}