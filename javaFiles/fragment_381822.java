// Assuming this static import:
import static org.jooq.impl.DSL.*;

DSL.using(configuration)
   .select()
   .from(TEST)
   .orderBy(TEST.ID)
   .seekAfter(field(select(TEST.ID).from(TEST).where(TEST.SID.eq(sid))))
   .limit(10)
   .fetch();