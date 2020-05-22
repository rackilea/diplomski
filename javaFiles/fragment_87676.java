@Entity
@Table(name = "devtypes")
public class DeviceType
{
    @Id
    @GeneratedValue
    @Column(name = "dev_type")
    private Integer deviceType;

    @Column(name = "dev_desc", length = 16)
    private String  description;