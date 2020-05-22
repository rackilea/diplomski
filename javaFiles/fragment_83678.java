<jdbc:dataSource id="dataSource"
         db-instance-identifier="myRdsInstance"
         username="${rdsUsername}"
         password="${rdsPassword}">
   <jdbc:pool-attributes initialSize="1" defaultCatalog="MyDb"
                          testOnBorrow="true" validationQuery="SELECT 1" />
</jdbc:dataSource>