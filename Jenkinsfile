pipeline{
  agent any
  
  stages{
//     stage('Checkout') {
//       steps{
//         git credentialsId: 'jyothi', url: 'git@github.com:jyothiswaroopreddy08/devops-project.git'
//       }
//      }
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
    stage("Quality Gate") {
            steps {
              timeout(time: 1, unit: 'MINUTE'){
               waitForQualityGate abortPipeline: true
            }
            }
          }
//     stage('Server'){
//     steps{
//     rtServer(
//     id: "jfrog",
//     url: 'https://jyothiserver.jfrog.io/artifactory',
//     bypassProxy: true,
//     timeout: 300
//             )
//         }
//     }
    stage('Artifactory Upload'){
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
      rtPublishBuildInfo(
   serverId: "jfrog"
        )
     }
    }
//    stage('Publish'){
//    steps{
//    rtPublishBuildInfo(
//    serverId: "jfrog"
//         )
//      }
//    }
    
  }
}
