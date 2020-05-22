db {
  default {
    driver=org.postgresql.Driver
    url="jdbc:postgresql://localhost/timeseries"
    user=postgres
    password=postgres

    hikaricp {
      dataSourceClassName = org.postgresql.ds.PGSimpleDataSource
      connectionTestQuery = "SELECT 1"
      # Data source configuration options. Must be INSIDE
      # the hikaricp "node" here
      dataSource {
        # anything you need to configure here
        ...
      }
    }
  }
}