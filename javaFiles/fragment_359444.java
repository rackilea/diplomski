model {
components {
    play {
        platform play: '2.4.8', scala: '2.11', java: '1.8'
        injectedRoutesGenerator = true
        tasks.withType(RoutesCompile) {
            additionalImports = ['play.libs.F']
        }

        sources {
            twirlTemplates {
                defaultImports = TwirlImports.JAVA
                source.srcDir "assets/views"
                source.exclude "assets/stylesheets"
            }
        }
     }
  }
}