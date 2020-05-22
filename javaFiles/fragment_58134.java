apply plugin: 'distribution'

distZip {
   def p = File.createTempFile('aaa', 'bbb')
   p.write "my.property: $project.myProperty\n"
   p.deleteOnExit()

    from(p) {
      rename {
         'server.properties'
      }
   }
}