embed-server --server-config=standalone.xml --std-out=echo

batch

module add --name=org.postgres --resources=${user.home}/Downloads/postgresql-42.2.8.jar --dependencies=javax.api,javax.transaction.api

/subsystem=datasources/jdbc-driver=postgres:add(driver-name="postgres",driver-module-name="org.postgres",driver-class-name=org.postgresql.Driver)


/subsystem=datasources/data-source=myDS/:add(connection-url=jdbc:postgresql://localhost:5432/dbname,driver-name=postgres,jndi-name=java:/jdbc/myDS,background-validation=true,background-validation-millis=60000,blocking-timeout-wait-millis=2000,flush-strategy=Gracefully,idle-timeout-minutes=5,initial-pool-size=4,max-pool-size=64,min-pool-size=4,password=the-password,query-timeout=10,track-statements=true,tracking=true,user-name=the-user,validate-on-match=false)

run-batch