public class PackageListener{
   //@Autowired
   Encryptor encryptor;

   @PrePersist
   public void preSave(final Package pack){
      encryptor = Application.context.getBean(Encryptor.class);
      pack.setBic(encryptor.encrypt(pack.getBic()));
   }
}