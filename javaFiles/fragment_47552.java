public class CreateDirectoryExample
{
    public static void main(String[] args) {    
        File worldDirectory = new File("C:\\Users\\xds\\Desktop\\world");
        if (!worldDirectory.exists()) {
            if (worldDirectory.mkdir()) {
                System.out.println("World directory is created!");
            } else {
                System.out.println("Failed to create World directory!");
            }
        }

        for(int i=1;i<=10;i++){
            File subWorldDir = new File("C:\\Users\\xds\\Desktop\\world\\" +i);
            if (!subWorldDir.exists()) {
                subWorldDir.mkdir();
                System.out.println("Created Sub World directory!");
            } else { 
                System.out.println("Failed to create Sub World directory!");
            }
        }

    }
}