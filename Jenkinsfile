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

        stage('Deploy image to dockerhub') {
          steps {
           //sh 'sudo docker pull kaddemproject:latest'
//           sh 'sudo docker tag kaddemproject:latest 192.168.33.10/kaddemproject:latest'
            sh 'sudo docker push yasmineb1831/kaddemproject1:kaddemproject '
          }
        }

      }
    }


     stage ('verify tooling')
       {
                steps {

            sh 'sudo docker info'
           sh 'sudo docker version'
            sh 'sudo docker compose version'
                }
       }
     stage ('Prune Docker data')
       {
                steps {
            sh 'sudo docker system prune -a --volumes -f'
                }
      }
     stage ('Start containers')
       {
                steps {

            sh 'sudo docker compose up -d --no-color --wait'
            sh 'sudo docker compose ps'
                }
        }


  }
}