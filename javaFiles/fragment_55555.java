@Endpoint(id = "sftp")
 @Component
 @RequiredArgsConstructor
 public class SftpEndpoint {
     @ReadOperation
     public Map<String, Object> sftp() {
     }
 }