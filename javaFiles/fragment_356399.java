-Dspring.config.location="C:\Project\properties\", -Dsecure.properties.location="C:\Project\properties\security\dev\"




 @PropertySources({ 
             @PropertySource("file:${spring.config.location}/configuration.properties"),
             @PropertySource("file:${secure.properties.location}/secure.properties")})