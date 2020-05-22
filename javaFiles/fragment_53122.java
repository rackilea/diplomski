stage('Run integration tests') {
  steps {
    script {
      try {
        timeout(30) {
          // Tear up integration test environment
          sh "docker-compose up -d"
          // Wait until it is ready
          waitUntil {
            "healthy" == sh(returnStdout: true,
              script: "docker inspect CONTAINER_NAME --format=\"{{ .State.Health.Status }}\"").trim()
          }

          docker.image('IMAGENAME').inside('--network projectname_default') {
            sh "gradle integrationTest"
          }
        }
      } finally {
        try {
          step([$class: 'JUnitResultArchiver', testResults: '**/build/integrationTest-results/TEST-*.xml'])
        } catch (Exception e) {
          // Ignore exception when there are no test results
        }
        sh "docker-compose logs >integration-test.log"
        sh "docker-compose down --rmi local --volumes --remove-orphans"
        archive 'integration-test.log'
      }
    }
  }
}