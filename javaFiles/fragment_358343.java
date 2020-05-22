@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue
    private Long codigo;
    private String razaosocial;
    private String cnpj;
    @OneToMany(mappedBy = "empresa")
    @JsonIgnoreProperties("empresa")
    private Set<Pessoa> pessoas;
}    

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Pessoa {

    @Id
    @GeneratedValue
    private Long codigo;
    private String nome;
    private String sexo;
    private String tipoPessoa;
    @ManyToOne
    @JoinColumn(name="codigoempresa")
    @JsonIgnoreProperties("pessoas")
    private Empresa empresa;
    private String cpf;

}