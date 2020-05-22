@Entity
@Table(name="\"Order\"")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Order extends PersistentEntity {
... rest of POJO def...
}