pipeline {
        parameters {
            string(name: 'AWS_ACCESS_KEY_ID', defaultValue: '')
        }

        stage("set credential") {
             steps {
               tmp_AWS_ACCESS_KEY_ID =  sh (script: 'your shell script here', returnStdout: true).trim()
               env.AWS_ACCESS_KEY_ID = tmp_AWS_ACCESS_KEY_ID
              }
        }
        stage("consume credential") {
            steps {
              echo "${env.AWS_ACCESS_KEY_ID}"
            }
        }
  }