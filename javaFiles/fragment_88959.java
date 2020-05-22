public class App {

    private String path = null;
    public static int index = 1;

    public App(String path){
        if (Files.isDirectory(Paths.get( path ))) {
            this.path = path;
        }
    }

    public void rename() throws IOException{
        if ( this.path != null){
            Files.list(Paths.get( this.path ))
            .forEach( f -> 
            {
                String fileName = f.getFileName().toString();
                String extension = fileName.replaceAll("^.*\\.([^.]+)$", "$1");             

                try {
                    Files.move( f ,Paths.get( this.path + "/" +   App.index + "." + extension));
                    App.index++;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }           
            );
        }
    }

    public static void main(String[] args) throws IOException {
        App app = new App("c:/Temp/");
        app.rename();
    }
}