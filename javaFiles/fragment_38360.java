import org.apache.cassandra.config.KSMetaData;
import org.apache.cassandra.config.Schema;
...
CQLSSTableWriter writer1 = CQLSSTableWriter.builder().inDirectory("keyspace/cf_1").forTable(<cf_1 create statement>).using(<cf_1 insert statement>).build();
... do your stuff with writer1....
// remove keyspace definition
KSMetaData ksm = Schema.instance.getKSMetaData("keyspace");
Schema.instance.clearKeyspaceDefinition(ksm);
CQLSSTableWriter writer2 = CQLSSTableWriter.builder().inDirectory("keyspace/cf_2").forTable(<cf_2 create statement>).using(<cf_2 insert statement>).build();
... do your stuff with writer2....