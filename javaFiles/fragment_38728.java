import javax.swing.JProgressBar;

public class ProgressBarListener
{

  private int transferedMegaBytes = 0;
  private JProgressBar progressBar = null;

  public ProgressBarListener()
  {
    super();
  }

  public ProgressBarListener(JProgressBar progressBar)
  {
    this();
    this.progressBar = progressBar;
  }

  public void updateTransferred(long transferedBytes)
  {
    transferedMegaBytes = (int) (transferedBytes / 1048576);
    this.progressBar.setValue(transferedMegaBytes);
    this.progressBar.paint(progressBar.getGraphics());
    System.out.println("Transferred: " + transferedMegaBytes + " Megabytes.");
  }
}