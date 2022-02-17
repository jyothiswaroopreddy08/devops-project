pipeline{
  agent any
  tools{
   maven "MAVEN_HOME"
  }
  stage('Checkout') {
      steps{
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/jyothiswaroopreddy08/DevOps']]])
      }
     }
  stage('Build'){
      steps{
        bat "mvn clean install"
      }
}
}
