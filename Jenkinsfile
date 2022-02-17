pipeline{
  agent any
  
  stages{
    stage('Checkout') {
      steps{
        git credentialsId: 'jyothi', url: 'git@github.com:jyothiswaroopreddy08/devops-project.git'
      }
     }
  stage('Build'){
      steps{
        bat "mvn clean install"
      }
    }
    stage('Test'){
      steps{
        bat "mvn clean test"
      }
    }
    stage('Package'){
      steps{
        bat "mvn clean package"
      }
    }
    stage('Sonar Scan'){
      steps{
        withSonarQubeEnv(installatioName: 'SonarQube', credentialsId: 'sonar-token') {
        bat "mvn sonar:sonar"
        }
      }
}
  }
}
