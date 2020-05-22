public class Dictionary implements Serializable {}
@Entity
@DiscriminatorValue("Foo")
public class Speciality extends Dictionary{}
@Entity
@DiscriminatorValue("ldp_type_profile")
public class LdpType extends Dictionary{}
@Entity
@Inheritance
@DiscriminatorColumn(name="which_profile")
public class QueueProfile {
    Dictionary profile;
}