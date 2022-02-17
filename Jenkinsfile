pipeline{
  agent any
  tools{
   maven "MAVEN_HOME"
  }
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
      stpes{
        bat "mvn clean package"
      }
    }
  }
}
