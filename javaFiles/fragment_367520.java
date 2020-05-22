@Inject
public AddressActions(EC2Service ec2Service,
                      RequestFactory requestFactory,
                      @Assisted("spiceManager") SpiceManager spiceManager,
                      @Assisted("parent") Context parent,
                      @Assisted("publicIp") @Nullable String publicIp) {