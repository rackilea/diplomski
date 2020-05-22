@MappedSuperclass
        @IdClass(Configuration.class)
        public class AbstractSubConfiguration implements Dto, Serializable {
            private static final long serialVersionUID = -6271877313478924753L;

            @Id
            @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "SYSTEM_ID", referencedColumnName = "SYSTEM_ID"),
        @JoinColumn(name = "configuration_CONFIGURATION_ID", referencedColumnName = "CONFIGURATION_ID")})            
private Configuration configuration;


...


....
}