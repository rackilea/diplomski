node {

.... Other code 

stage("development") {
                withEnv(['JENKINS_NODE_COOKIE=someName']) {
                    sh 'nohup ./mvnw spring-boot:run -Dspring.profiles.active=e1 &'
                }   
}

}