@GenericGenerator(name = "AID_SERIAL", strategy = "my.package.structure.AdvAidValueGenerator",
                  parameters = {
                                    @Parameter(name="table", value="serial"),
                                    @Parameter(name="primary_key_column", value="name"),
                                    @Parameter(name="max_lo", value="0"),
                                    @Parameter(name="table", value="serial"),
                                    @Parameter(name="value_column", value="no"),
                                    @Parameter(name="primary_key_value", value="adv")
                  })
@GeneratedValue(generator="AID_SERIAL")
@Column(name = "AID")
@Id
public Integer getAid() {


   return aid;
}



public class AdvAidValueGenerator extends MultipleHiLoPerTableGenerator {

        @Override
        public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
            if(!(object instanceof AdvEntity)) {
                throw new IllegalArgumentException("AdvAidValueGenerator should only be used for AdvEntity");
            }

            final AdvEntity advEntity = (AdvEntity) object;
            final Integer presentAid = advEntity.getAid();
            if(null == presentAid) {
                return super.generate(session, object);
            }
            return presentAid;
        }
}