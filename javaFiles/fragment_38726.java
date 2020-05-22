import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

public class ApplicationView implements ActionListener
{

  File file = new File("C:/Temp/my-upload.avi");
  JProgressBar progressBar = null;

  public ApplicationView()
  {
    super();
  }

  public void createView()
  {
    JFrame frame = new JFrame("File Upload with progress bar - Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(0, 0, 300, 200);
    frame.setVisible(true);

    progressBar = new JProgressBar(0, 100);
    progressBar.setBounds(20, 20, 200, 30);
    progressBar.setStringPainted(true);
    progressBar.setVisible(true);

    JButton button = new JButton("upload");
    button.setBounds(progressBar.getX(),
            progressBar.getY() + progressBar.getHeight() + 20,
            100,
            40);
    button.addActionListener(this);

    JPanel panel = (JPanel) frame.getContentPane();
    panel.setLayout(null);
    panel.add(progressBar);
    panel.add(button);
    panel.setVisible(true);
  }

  public void actionPerformed(ActionEvent e)
  {
    try
    {
      sendFile(this.file, this.progressBar);
    }
    catch (Exception ex)
    {
      System.out.println(ex.getLocalizedMessage());
    }
  }

  private void sendFile(File file, JProgressBar progressBar) throws Exception
  {
    String serverResponse = null;
    HttpParams params = new BasicHttpParams();
    params.setParameter(HttpProtocolParams.USE_EXPECT_CONTINUE, true);
    HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
    HttpClient client = new DefaultHttpClient(params);
    HttpPut put = new HttpPut("http://localhost:8080/" + file.getName());

    ProgressBarListener listener = new ProgressBarListener(progressBar);
    FileEntityWithProgressBar fileEntity = new FileEntityWithProgressBar(file, "binary/octet-stream", listener);
    put.setEntity(fileEntity);

    HttpResponse response = client.execute(put);
    HttpEntity entity = response.getEntity();
    if (entity != null)
    {
      serverResponse = EntityUtils.toString(entity);
      System.out.println(serverResponse);
    }
  }
}