pipeline{
  agent any
  
  stages{

  stage('Build'){
      steps{
        bat "mvn install"
      }
    }
    
    stage('Compile'){
      steps{
        bat "mvn compile"
      }
    }

    stage('Sonar Scan'){
      steps{
        withSonarQubeEnv(installationName: 'SonarQube', credentialsId: 'sonar-token') {
        bat "mvn sonar:sonar"
        }
      }
    }  
  }
}
