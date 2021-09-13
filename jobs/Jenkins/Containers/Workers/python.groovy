#!groovy

pipelineJob('Jenkins/Containers/Workers/python') {
  displayName 'python'

  description 'Build and publish the Jenkins Worker Python Docker Container'

  properties {

    githubProjectUrl 'https://github.com/Trility/jenkins-fargate-kcdc-2021'

  }

  parameters {

    choiceParam(
      'AWS_REGION', [
        'us-west-2'
      ],
      'AWS Region to use'
    )

  }

  definition {
    cpsScm {
      scriptPath 'docker/jenkins-workers/python/Jenkinsfile'
      scm {
        git {
          remote {
            name 'origin'
            url 'https://github.com/Trility/jenkins-fargate-kcdc-2021.git'
          }
          branch 'main'
        }
      }
    }
  }
}
