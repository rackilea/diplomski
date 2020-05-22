@Entity
@Table(name = "Fat_Pedido")
public class FatPedido implements Serializable {

    ...

    @OneToOne(mappedBy = "fatPedido")
    private LojCupom lojCupom;

    ...

}