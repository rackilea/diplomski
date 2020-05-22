public class Request {

 private int requestId;
 //I don't see any need for this
 //private int server_serverId; // foreign key to Server.serverId
 private Server server;
 ...
 @ManyToOne ( fetch=FetchType.LAZY ) //employ lazy loading, you can put that on @OneToMany too
 @JoinColumn( name="server_serverId", nullable=false }
 public Server getServer() {
  return server;
 }
}