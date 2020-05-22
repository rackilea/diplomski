defaults {
            publications ('mavenJava')
            publishArtifacts = true

            properties = ['qa.level': 'basic', 'q.os': 'android', 'dev.team': 'core']
            publishPom = false
        }