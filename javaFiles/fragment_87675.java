@Embeddable
public class DeviceModelId implements Serializable
{
    private static final long   serialVersionUID    = -8173857210615808268L;
    private Integer deviceType;
    @Column(name="model_nbr")
    private Integer modelNumber;