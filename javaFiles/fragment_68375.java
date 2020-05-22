@Repository
interface RelationABEntityRepository extends JpaRepository<RelationABEntity, RelationABId> {

}

@Repository
interface ARepository extends JpaRepository<EntityA, Long> {


}

@Repository
interface BRepository extends JpaRepository<EntityB, Long> {

}