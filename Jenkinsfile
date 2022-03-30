pipeline{
  agent any
  
  stages{

  stage('Build'){
      steps{
        bat "mvn install"
      }
    }
    
//     stage('Test'){
//       steps{
//         bat "mvn test"
//       }
//     }
//     stage('Package'){
//       steps{
//         bat "mvn package"
//       }
//     }
//     stage('Sonar Scan'){
//       steps{
//         withSonarQubeEnv(installationName: 'SonarQube', credentialsId: 'sonar-token') {
//         bat "mvn sonar:sonar"
//         }
//       }
//     }
//     stage("Quality Gate") {
//             steps {
//                waitForQualityGate abortPipeline: true
           
//             }
//           }

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

    
  }
}
