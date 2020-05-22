@Entity
@Table(name = "Loj_Cupons")
public class LojCupom implements Serializable {#

    ...

    @OneToOne     
    @JoinColumns({
        @JoinColumn(name = "Empresa_Pedido", referencedColumnName = "Empresa"),
        @JoinColumn(name = "Pedido_Fat", referencedColumnName = "Pedido") })
    private FatPedido fatPedido;

    ...

}