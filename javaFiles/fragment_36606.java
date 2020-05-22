public class ConfigInstance {

    @Expose
    public String database_address;
    @Expose
    public int database_port;
    @Expose
    public String database_user;

    @Expose(serialize = false)
    private String database_pass;
    @Expose
    public String database_pass_hash;