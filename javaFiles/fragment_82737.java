EE.5.19 Default Data Source
The Java EE Platform requires that a Java EE Product Provider provide a database
in the operational environment (see Section EE.2.6, “Database”). The Java EE
Product Provider must also provide a preconfigured, default data source for use by
the application in accessing this database.

The Java EE Product Provider must make the default data source accessible to
the application under the JNDI name java:comp/DefaultDataSource.

The Application Component Provider or Deployer may explicitly bind a
DataSource resource reference to the default data source using the lookup element
of the Resource annotation or the lookup-name element of the resource-ref
deployment descriptor element. For example,

@Resource(lookup="java:comp/DefaultDataSource")
DataSource myDS;

In the absence of such a binding, the mapping of the reference will default to
the product's default data source.

For example, the following will map to a preconfigured data source for the
product's default database:

@Resource
DataSource myDS;