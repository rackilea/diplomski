// Assuming this:
import static org.jooq.impl.DSL.*;

create.insertInto(table(name("TestTable")))
      .set(field(name("testColumn")), 1)
      .execute();