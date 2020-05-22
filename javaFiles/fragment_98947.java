@Configuration
public class FilesystemConfiguration {

    @Bean
    File filesystemRoot() {
        try {
            return new File("/path/to/your/user/profile/image/store");
        } catch (IOException ioe) {}
        return null;
    }

    @Bean
    FileSystemResourceLoader fileSystemResourceLoader() {
        return new FileSystemResourceLoader(filesystemRoot().getAbsolutePath());
    }
}