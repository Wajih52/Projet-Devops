pipeline {
  agent {label 'VagrantAgent'}
  stages {
//     stage('Tests') {
//     parallel {
//         stage('Unit Testing ') {
//           steps {
//             sh 'mvn test --Ptest'
//           }
//         }
//
//         stage('SRC analysis Testing') {
//           steps {
//             sh 'mvn verify sonar:sonar -Dsonar.login=admin -Dsonar.password=Lucifer1831'
//           }
//         }
// }
//
//     }

    stage('Build ') {
      parallel {
        stage('Build artifact') {
          steps {
            sh 'mvn clean package -Pprod'
          }
        }

        stage('Build Docker Image') {
          steps {
            sh 'sudo docker build -t kaddemproject . '
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
          sh 'sudo docker pull kaddemproject'
          sh 'sudo docker tag kaddemproject 192.168.33.10/kaddemproject:latest'
            sh 'sudo docker push 192.168.33.10:8082/kaddemproject:latest '
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