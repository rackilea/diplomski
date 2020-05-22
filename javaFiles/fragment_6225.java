@Override
@Autowired
public void setCriteriaBuilder(
    @Qualifier("hibernateCriteriaBuilder") IQueryCriteriaBuilder<Entity> criteriabuilder)
{
    super.setCriteriaBuilder(criteriaBuilder):
}