@Entity
@AssociationOverride(name="company",
                     joinColumns=@JoinColumn(name="id_company", nullable=true))
public class Company extends BaseEntityImpl {
   ....
}