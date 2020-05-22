@Entity
@Table(name="device_info")
public class DeviceInfo {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="DEVICE_ID")
    private Integer deviceId;

    @Column(name="DEVICE_KEY")
    private String deviceKey;

  @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "PK_USER_ID", nullable = false)
    private User user;
}