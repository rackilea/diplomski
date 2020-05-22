{
     "name": "default",
     "label": "master",
     "propertySources": [
          {
                "name": "applicationConfig: [classpath:/myapp.yml]",
                "source": {
                     "my.otherprop": "myotherval"
                }
          },
          {
                "name": "applicationConfig: [classpath:/application.yml]",
                "source": {
                     "spring.application.name": "myconfigserver",
                     "spring.profiles.active": "native",
                     "my.property": "myvalue"
                }
          }
     ]
}