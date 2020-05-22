/** Redirects the log output to the SDCard.
 *  
 * make sure your app has the WRITE_EXTERNAL_STORAGE and READ_LOGS permissions - 
 *  or it won't allow it to read logs and write them to the sdcard.
 *  If the application doesn't have the permissions, there will be no exception
 *  and the program will continue regularly.
 */
public static void redirectOutputToFile()
{
    s_enableLogs = true;

    if (s_logcatProcess != null)
    {
        Logger log = new Logger("Logger");  

        log.info("redirectOutputToFile() called more then once, perhaps from service onCreate and onStart.");

        return;
    }

    try 
    {
        String path = Environment.getExternalStorageDirectory() + LOG_FILE_NAME;
        File filename = new File(path);

        filename.createNewFile();

        //http://www.linuxtopia.org/online_books/android/devguide/guide/developing/tools/android_adb_logcatoptions.html
        String cmd = String.format("logcat -v time -f %s -r %d -n %d", filename.getAbsolutePath(), LOG_FILE_SIZE_KB, LOG_FILE_ROTATIONS);    

        s_logcatProcess = Runtime.getRuntime().exec(cmd);
    } 
    catch (IOException e) 
    {       
        Logger log = new Logger("Logger");
        log.exception(e);
    }
}

/** Kills the logcat process that was created in the redirectOutputToFile() method. */
public static void killLogcatProcess()
{
    // first update the log mode state
    s_enableLogs = false;

    if (s_logcatProcess != null)
    {
        s_logcatProcess.destroy();
        s_logcatProcess = null;
    }
}