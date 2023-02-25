pipeline {
  agent {label 'VagrantAgent'}
  stages {
    stage('Tests') {
//       parallel {
//         stage('Unit Testing ') {
//           steps {
//             sh 'mvn test -Ptest'
//           }
//         }

        stage('SRC analysis Testing') {
          steps {
            sh 'mvn verify sonar:sonar -Dsonar.login=admin -Dsonar.password=Lucifer1831'
          }
        }

      }
    }

    stage('Build ') {
      parallel {
        stage('Build artifact') {
          steps {
            sh 'mvn clean package -Pprod'
          }
        }

        stage('Build Docker Image') {
          steps {
            sh 'docker build -t kaddemproject . '
          }
        }

      }
    }

    stage('Deploy') {
      parallel {
        stage('Deploy artifact to Nexus') {
          steps {
            sh 'mvn deploy -Pprod'
          }
        }

        stage('Deploy image to Nexus') {
          steps {
            sh 'docker push 192.168.33.10:8081//kaddemproject:latest '
          }
        }

      }
    }

    stage('Start Containers') {
      steps {
        sh 'docker-compose up -d'
      }
    }

  }
}