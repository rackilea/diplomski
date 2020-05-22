configurations.all { conf ->
        exclude group: 'org.hibernate', module: 'hibernate-annotations'
        resolutionStrategy {

            // Forces one verion among the project
            force "org.hibernate.common:hibernate-commons-annotations:4.0.5.Final"
        }
}