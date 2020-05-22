from project(':module0').fileTree('resource')
webInf {
  from gradleProject.project(':module1').fileTree(dir: 'config/props/skel',
    includes: ['*.properties', '*.xml'], excludes: ['blah1.properties', 'blah2.properties'])
    filesMatching('WEB-INF/classes/props/*'){
      filter(ReplaceTokens, tokens: props)
    }
}.into('classes/props/')//.filter(ReplaceTokens, tokens: props)