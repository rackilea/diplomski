import java.io.File;
    import java.util.Arrays;
    import java.util.Comparator;

    public class PurgeFiles
    {

        public static void main(String[] args)
        {
            purgeFiles(10, 10, "C:/testdir/");
        }

        public static void purgeFiles(int daysToRetain, int filesToRetain, String directory)
        {

            File backupDir = new File(directory);
            long purgeTime = System.currentTimeMillis() - (daysToRetain * 24L * 60L * 60L * 1000L);
            if (backupDir.exists())
            {
                File[] listOfBackupFiles = backupDir.listFiles();

                Arrays.sort(listOfBackupFiles, new Comparator<File>()
                {
                    public int compare(File f1, File f2)
                    {
                        return Long.valueOf(f2.lastModified()).compareTo(f1.lastModified());
                    }
                });

                if(listOfBackupFiles.length > filesToRetain){
                    File[] listOfBackupFilesToCheckForDeletion = new File[listOfBackupFiles.length - filesToRetain];
                    System.arraycopy(listOfBackupFiles, filesToRetain, listOfBackupFilesToCheckForDeletion, 0, listOfBackupFiles.length - filesToRetain);

                    for (File backupFile : listOfBackupFilesToCheckForDeletion)
                    {
                        if (backupFile.lastModified() < purgeTime)
                        {
                            if (backupFile.isFile())
                            {
                                System.out.println(backupFile.getName() + ", " + backupFile.lastModified() + " is going to delete");
                                backupFile.delete();
                            }
                        }
                    }
                }
            }
        }
    }