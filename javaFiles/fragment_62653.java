war {
  doFirst{
    replaceTokens() // Update rev number
  }
  baseName = nome

  from('config') {
    include 'ibm-web-ext.xml'
    into 'WEB-INF'

    manifest {
      attributes("Application-Name": baseName,
                 "Implementation-Version": versione + 'rev_' + getSvnRevision())
    }
  }
}