public class Patient implements Serializable 
{
   @Id
   @SequenceGenerator(name = "PatientSequenceGenerator", sequenceName = "lab_patient_seq")
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PatientSequenceGenerator")
   private Long id;
}