@Configuration
@EnableIntegration
@IntegrationComponentScan
public class Configuration {

    @Bean
    public IntegrationFlow uploadFiles() {
        return f ->
                   f.split()
                       .handle(Ftp.outboundGateway(this.ftpSessionFactory,
                           AbstractRemoteFileOutboundGateway.Command.PUT, "'remoteDirectory'"))
                       .aggregate();
    }

}

@MessagingGateway(defaultRequestChannel = "uploadFiles.input") 
interface FtpUploadGateway {

    List<String> upload(List<File> filesToUpload);

}