task replaceUnescapedApostrophes {
    doFirst {
        ant.replaceregexp(match: "([^\\\\])'", replace: "\\1\\\\\\\\'",  byline: "true") {
            fileset(dir: 'src/', excludes: '*', includes: '**/*strings.xml')
        }
    }
}

//preBuild.dependsOn(checkUnescapedApostrophes)
preBuild.dependsOn(replaceUnescapedApostrophes)