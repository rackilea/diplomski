@Entity
public class DeviceModel extends Model implements PathBindable<DeviceModel> {

@Id
public Long id;


@Lob
@Basic(fetch=FetchType.LAZY)
private byte[] picture;


public byte[] getPicture() {
    return picture;
}

public void setPicture(byte[] picture) {
    this.picture = picture;
}

...