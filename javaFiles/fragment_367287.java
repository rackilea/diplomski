// Captcha sound generator
//remember to change Voice.java file's deallocation() method as it was creating problems while compilation.Rebuild freetts source and use that.

public class CustomSoundCaptchaService {
private static SoundCaptchaService instanceSound=null;

public static SoundCaptchaService getInstance(WordGenerator wordGen){

     SoundConfigurator soundConfig = new FreeTTSSoundConfigurator("kevin16", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory", 1.0f, 100, 100);

     WordToSound word2sound = new FreeTTSWordToSound(soundConfig,6,7);

     CaptchaFactory[] factories = new CaptchaFactory[]{new GimpySoundFactory(wordGen, word2sound)};

     CaptchaEngine captchaEngine = new GenericCaptchaEngine(factories);

     instanceSound = new GenericManageableCaptchaService(captchaEngine, 180,180000, 75000);
     return instanceSound;
     }
}



//invoking servlet 
public class SoundCaptchaServlet extends HttpServlet {
private static final long serialVersionUID = 1L;


/**
 * @see HttpServlet#HttpServlet()
 */
public SoundCaptchaServlet() {
    super();
    // TODO Auto-generated constructor stub
}

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub

    AudioInputStream audioCaptcha=null;
    try {
        String captchaId = request.getSession().getId();
        WordGenerator wordGen= new RandomWordGenerator("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwzxyz0123456789");
        audioCaptcha=CustomSoundCaptchaServlet.getInstance(worGen).getSoundChallengeForID(captchaId);

    } catch (IllegalArgumentException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    } catch (CaptchaServiceException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }

    response.setDateHeader("Expires", 0);
    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
    response.addHeader("Cache-Control", "post-check=0, pre-check=0");
    response.setHeader("Pragma", "no-cache");
    response.setContentType("audio/mpeg");
    ServletOutputStream out = response.getOutputStream();
    ByteArrayOutputStream soundByteOutputStream = new ByteArrayOutputStream();
    AudioSystem.write(audioCaptcha,javax.sound.sampled.AudioFileFormat.Type.WAVE,soundByteOutputStream);
    out.write(soundByteOutputStream.toByteArray());
    out.flush();
    out.close();
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
}

//replace existing code in Voice.java with following
public void deallocate() {
setLoaded(false);
utteranceProcessors.clear();

    if (!externalAudioPlayer) {
        if (audioPlayer != null) {
            audioPlayer.close();
            audioPlayer = null;
        }
    }

if (!externalOutputQueue) {

}
}