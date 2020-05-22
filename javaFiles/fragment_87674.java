@Entity
@Table(name = "devmodels")
public class DeviceModel
{
    @EmbeddedId
    private DeviceModelId id;

    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="dev_type")
    @MapsId("deviceType")
    private DeviceType deviceType;

    @Column(name = "model_desc", length=20)
    private String  description;