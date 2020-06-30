import java.io.File;

public class CountJavaProjects {

    public static void main(String[] args) {
        File mostPopularRepos = new File("/Users/lracki/Desktop/GitRepos/MostPopularRepos");
        File[] directoryListing = mostPopularRepos.listFiles();

        File Repos0Stars = new File("/Users/lracki/Desktop/GitRepos/0StarsRepos");
        File[] directoryListing2 = Repos0Stars.listFiles();

        File Repos10Stars = new File("/Users/lracki/Desktop/GitRepos/10stars");
        File[] directoryListing3 = Repos10Stars.listFiles();

        File Repos1000Stars = new File("/Users/lracki/Desktop/GitRepos/1000StarsRepos");
        File[] directoryListing4 = Repos1000Stars.listFiles();

        long totalNumberOfProjects = 0;

        long counter = 0;
        if (directoryListing != null) {
            for (File child : directoryListing) {
                if(child.isDirectory()) {
                    counter += child.listFiles().length;
                }
            }
            totalNumberOfProjects += counter;
        }
        System.out.println("MostPopularRepos projects : " + counter);


        counter = 0;
        if (directoryListing2 != null) {
            for (File child : directoryListing2) {
                if(child.isDirectory()) {
                    counter += child.listFiles().length;
                }
            }
            totalNumberOfProjects += counter;
        }
        System.out.println("0StarsRepos projects : " + counter);

        counter = 0;
        if (directoryListing3 != null) {
            for (File child : directoryListing3) {
                if(child.isDirectory()) {
                    counter += child.listFiles().length;
                }
            }
            totalNumberOfProjects += counter;
        }
        System.out.println("10StarsRepos projects : " + counter);

        counter = 0;
        if (directoryListing4 != null) {
            for (File child : directoryListing4) {
                if(child.isDirectory()) {
                    counter += child.listFiles().length;
                }
            }
            totalNumberOfProjects += counter;
        }
        System.out.println("1000StarsRepos projects : " + counter);

        System.out.println("Total number of projects : " + totalNumberOfProjects);
    }
}
