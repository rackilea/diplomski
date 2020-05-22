subprojects { 
    project.afterEvaluate {
        eclipse.classpath.file.withXml {
            it.asNode().'classpathentry'.each { entry ->
                def path = entry.@path.toLowerCase()
                if (path.contains('your-jar-to-ignore')) {
                    entry.attributes.each { attr ->
                        if (attr.attribute.@name.contains('org.eclipse.jst.component.dependency')) {
                            entry.remove(attr)
                        }
                    }
                }
            }
        }
    }
}