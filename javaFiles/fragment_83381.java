@Entity
@Table(name="person_company")
public class PersonCompany {
   ...

@ManyToOne
@JoinColumn(name = "person_id")
Person person

@ManyToOne
@JoinColumn(name = "company_id")
Company company
}