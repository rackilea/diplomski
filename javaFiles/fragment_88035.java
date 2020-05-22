@NoRepositoryBean
public interface AbstractARepository<T extends A>
                                    extends Repository<T, Long> {
    T findByName(String name); //or what ever your queries are
}

public ARepository extends AbstractARepository<A> {
   //almost emtpy
}


public BRepository extends AbstractARepository<B> {
   //queries that are special for B
}