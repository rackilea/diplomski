public class FileManager {

    File dir;
    File driveFile;
    BufferedWriter writer=null;
    BufferedReader reader=null;
    public FileManager(Context context,String name){
        dir = new File(context.getFilesDir(),"drives");
        dir.mkdirs();
        driveFile = new File(dir,name+".txt");
        Log.d("FileManager",driveFile.getAbsolutePath());
    }

    public void writeTrackPoints(Drive drive) throws IOException{
        writer = new BufferedWriter(new FileWriter(driveFile));
        TrackPoint [] trackPoints=drive.getTrackPoints();
        for(int i=0;i<trackPoints.length;i++){
            String line = trackPoints[i].getParsingString()+"\r\n";
            writer.write(line);
            writer.flush();
        }
        writer.close();
    }

    public void readTrackPoints(Drive drive) throws IOException{
        reader = new BufferedReader(new FileReader(driveFile));
        String line=null;
        while((line = reader.readLine())!=null){
            drive.addTrackPoint(new TrackPoint(line));
        }
        reader.close();
    }
}