import java.util.Date;
import java.util.TimerTask;

public class agrPullingAgentStudy {

    private static Date m_dAliveDT = new Date();

    private class dcmStudySchedule extends TimerTask {

        public void run() {
            m_dAliveDT = new Date();
        }
    }
}