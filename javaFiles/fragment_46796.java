compile('org.hibernate:hibernate:3.1') {
  //excluding a particular transitive dependency:
  exclude module: 'cglib' //by artifact name
  exclude group: 'org.jmock' //by group
  exclude group: 'org.unwanted', module: 'iAmBuggy' //by both name and group
}