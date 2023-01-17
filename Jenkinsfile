pipeline{
  agent any
      tools {
        maven 'MAVEN_HOME'
      }
  stages{

  stage('Build'){
      steps{
        sh 'mvn install'
      }
    }
    
    stage('Compile'){
      steps{
        sh "mvn compile"
      }
    }

    stage('Sonar Scan'){
      steps{
        withSonarQubeEnv(installationName: 'SonarQube', credentialsId: 'sonar-token') {
        sh "mvn sonar:sonar -Dsonar.projectVersion=$JOB-NAME-$BUILD_ID"
        }
      }
    }  
  }
}
