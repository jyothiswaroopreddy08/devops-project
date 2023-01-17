pipeline {
  agent any       
  tools {
        maven 'MAVEN_HOME'
      }
  stages {
    stage('Build') {
      
      steps {
        script {
          def version = "${env.JOB_NAME}-${env.BUILD_ID}"
          sh "mvn clean install" 
          sh "mvn sonar:sonar -Dproject.version=${version} -Dsonar.projectKey='com.devops:devops-project' -Dsonar.host.url=http://localhost:9000/ -Dsonar.password='ammusiri99@S'"
        }
      }
    }
  }
}
