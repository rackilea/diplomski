import org.junit.*;
import org.junit.runner.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PrescriptionRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PrescriptionRepository repository;

    @Test
    public void savePrescription() throws Exception { 
        this.repository.savePrescription(...);
        Prescription actualPrescription = em.findById(...); 
        assertThat(actualPrescrition.getDoseId()).isEqualTo("doseId...");
        assertThat(actualPrescrition.getMedId()).isEqualTo("medId...");
    }

}