public class GameLogicThread extends Thread
{
    private GameScreen m_screen;
    private boolean m_runing;
    private long m_timeBegin;
    private long m_timeDiff;
    private long m_sleepTime;
    private final static float FRAMERATE = 210f;

    public GameLogicThread(GameScreen screen)
    {
        m_screen = screen;
        setName("GameLogic");
    }

    @Override
    public void run()
    {
        m_runing = true;
        Logger.log("Started");
        while (m_runing)
        {
            m_timeBegin = TimeUtils.millis();
            // hanlde events
            m_screen.m_main.handler.processEvents();
            synchronized (m_screen.figureStage)
            {
                // now figures
                if (m_screen.m_status == GameStatus.GAME)
                {
                    m_screen.character.myAct(1f / GameLogicThread.FRAMERATE);// and here it is ;)
                    m_screen.figureStage.act(1f / GameLogicThread.FRAMERATE);
                }
            }
            m_timeDiff = TimeUtils.millis() - m_timeBegin;
            m_sleepTime = (long) (1f / GameLogicThread.FRAMERATE * 1000f - m_timeDiff);
            if (m_sleepTime > 0)
            {
                try
                {
                    Thread.sleep(m_sleepTime);
                }
                catch (InterruptedException e)
                {
                    Logger.error("Couldn't sleep " + e.getStackTrace());
                }
            }
            else
            {
                Logger.error("we are to slow! " + m_sleepTime);
            }
        }
    }

    public void stopThread()
    {
        m_runing = false;
        boolean retry = true;
        while (retry)
        {
            try
            {
                this.join();
                retry = false;
            }
            catch (Exception e)
            {
                Logger.error(e.getMessage());
            }
        }
    }
}