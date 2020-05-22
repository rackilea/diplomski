@Entity
@IdClass(OperationRolePk.class)
public class OperationRole{

        @Id
        @ManyToOne
        @JoinColumn(name = "id_operation")
        private Operation operation;

        @Id
        @ManyToOne
        @JoinColumn(name = "id_menu")
        private Menu menu;

        @Id
        @ManyToOne
        @JoinColumn(name = "id_user")
        private User user;
}