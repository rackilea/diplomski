@Entity
@Table(name = "devices")
public class Device
{
    @Id
    @Column(name = "device_nbr")
    private Long number;

    @Column(name = "device_id", length = 20)
    private String deviceId;

    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumns({@JoinColumn(name="dev_type", referencedColumnName="dev_type"), @JoinColumn(name="model_nbr", referencedColumnName="model_nbr")})
    private DeviceModel deviceModel;

    // This creates a foreign key constraint, but otherwise doesn't function
    // deviceType must be accessed through deviceModel
    // note, it can be used for explicit selects, e.g., "select d.deviceType from Device d"
    @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="dev_type", referencedColumnName="dev_type", insertable=false, updatable=false)
    private DeviceType deviceType;

    @Column(name = "unit_addr", length = 32)
    private String unitAddress;