@Configuration
@ComponentScan("somepackage.service")// scan for services, but not for DAOs!
public class Config {

    @Bean(autowire = Autowire.BY_NAME)
    public GenericDaoJpaImpl<AlerteAcheteur, Long> alerteAcheteurDao() {
        return new GenericDaoJpaImpl<AlerteAcheteur, Long>(AlerteAcheteur.class);
    }

    @Bean(autowire = Autowire.BY_NAME)
    public GenericDao<AlerteVendeur, Long> alerteVendeurDao() {
          return new GenericDaoJpaImpl<AlerteVendeur, Long>(AlerteVendeur.class);
    }

   // other DAOs

   ...
}