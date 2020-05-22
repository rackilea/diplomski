@Entity
@Table(name = "COM_ORDER")
@DiscriminatorColumn(name = "COM_ORDER_TYPE", discriminatorType = DiscriminatorType.INTEGER)
public class BaseUser {
    @Id
    private Long id;
    <Enter your generic columns here, you do not need to add the user_type column>
}

@Entity
@DiscriminatorValue("1")
public class LegacyUser extends BaseUser {
    <Enter your legacy specific fields here>
}

@Entity
@DiscriminatorValue("2")
public class LatestUser extends BaseUser {
    <Enter your new and improved user fields here>
}