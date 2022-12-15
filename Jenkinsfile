pipeline{
  agent any
  
  stages{

  stage('Build'){
      steps{
        sh "mvn install"
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
        sh "mvn sonar:sonar"
        }
      }
    }  
  }
}
