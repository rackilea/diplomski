/**
 * Context.MODE_PRIVATE will create the file (or replace a file of the same name) and make it private to your application.
 * Other modes available are: MODE_APPEND, MODE_WORLD_READABLE, and MODE_WORLD_WRITEABLE.
 */

public static void createInternalFile(Context theContext, String theFileName, byte[] theData, int theMode)
{
    FileOutputStream fos = null;

    try {
        fos = theContext.openFileOutput(theFileName, theMode);
        fos.write(theData);
        fos.close();
    } catch (FileNotFoundException e) {
        Log.e(TAG, "[createInternalFile]" + e.getMessage());
    } catch (IOException e) {
        Log.e(TAG, "[createInternalFile]" + e.getMessage());
    }
}