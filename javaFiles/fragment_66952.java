{
  "icon": "service",
  "title": "A",
  "type": "service",
  "children": [
    {
      "icon": "sharedlibraries",
      "title": "sharedlibraries",
      "type": "sharedlibraries",
      "children": [
        {
          "icon": "war",
          "title": "abc.war ( ui-shared-lib )",
          "path": "abc/common/Services/1.2.0/lib/comp.war",
          "reference": "abc/common/templates/applications/11.1.2.3.jar/config/config.xml",
          "type": "sharedlibrary",
          "version": "11.1.2.0@11.1.2.0",
          "children": [
            {
              "icon": "jar",
              "title": "comp1.jar",
              "path": "abc/common/SharedServices/1.2.0/lib/comp.war/WEB-INF/lib/comp.jar",
              "reference": "abc/common/Services/1.2.0/lib/comp.war/WEB-INF/lib",
              "type": "jar",
              "thirdpartyjar": "true"
            }
          ]
        }
      ]
    }
  ]
}