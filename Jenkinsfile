pipeline {

    agent {label 'DevopsNode'}


    stages {
        stage ('GIT') {
            steps {
               echo "Getting Project from Git"; 
                git branch: "Wajih", 
                    url: "https://github.com/Wajih52/Projet-Devops.git";
            }
        }
       
        stage("Build artifact") {
            steps {
                sh "mvn clean package -DskipTests"
            }
        }

        
        stage("Build Docker image") {
            steps {
                sh "sudo docker build -t springproject ."
            }
        }

        stage("Deploy Artifact to private registry Nexus") {
            steps {
                sh "mvn deploy -DskipTests"
            }
        }

        stage("Deploy Dokcer Image to Docker HUb") {
            steps {
                sh "sudo docker login -u wajihrjb -p Docker.Wajih.19.01"
				sh "sudo docker tag springproject:latest wajihrjb/springproject:1.0"
				sh "sudo docker push wajihrjb/springproject:1.0"
            }
        }
		 stage("lancer docker compose ") {
            steps {
                sh "sudo docker compose up -d"
				
            }
        }
    }
   
    post {
        always {
            cleanWs()
        }
    }
    
}