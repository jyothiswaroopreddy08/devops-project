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
        bat "mvn install"
      }
    }
    
    stage('Test'){
      steps{
        bat "mvn test"
      }
    }
    stage('Package'){
      steps{
        bat "mvn package"
      }
    }
    stage('Sonar Scan'){
      steps{
        withSonarQubeEnv(installationName: 'SonarQube', credentialsId: 'sonar-token') {
        bat "mvn sonar:sonar"
        }
      }
    }
    stage("Quality Gate"){
          timeout(time: 1, unit: 'HOURS') {
              def qg = waitForQualityGate()
              if (qg.status != 'OK') {
                  error "Pipeline aborted due to quality gate failure: ${qg.status}"
              }
          }
    }
    stage('Server'){
    steps{
    rtServer(
    id: "jfrog",
    url: 'https://jyothiserver.jfrog.io/artifactory',
    bypassProxy: true,
    timeout: 300
            )
        }
    }
    stage('Upload'){
    steps{
    rtUpload(
    serverId: "jfrog",
    spec: '''{
    "files": [
    {
    "pattern": "*.jar",
    "target": "devops-pipeline-libs-snapshot-local"
                }
            ]
        }''',
      )
     }
    }
   stage('Publish'){
   steps{
   rtPublishBuildInfo(
   serverId: "jfrog"
        )
     }
   }
    
  }
}
