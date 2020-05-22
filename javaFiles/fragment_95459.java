@Entity
@Table
@OnDelete(action = OnDeleteAction.CASCADE)
public class SubTable extends Table {
    ...
}