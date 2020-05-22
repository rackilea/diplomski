@Configuration
public class ValidationConfig {

@Autowired
IQualificacao iQualificacao;

@Bean
public AberturaMatriculaValidator aberturaMatriculaValidator() {
    return new AberturaMatriculaValidator(iQualificacao);
}
}