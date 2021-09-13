#!groovy

pipelineJob('Jenkins/Terraform/jenkins-service') {
  displayName 'jenkins-service'

  description 'Build and publish the Jenkins Service'

  properties {

    githubProjectUrl 'https://github.com/Trility/jenkins-fargate-kcdc-2021'

  }

  parameters {

    stringParam (
      'DOCKER_IMAGE',
      '',
      'ECR Docker repository, image, and tag for Jenkins deployment'
    )

    choiceParam(
      'AWS_REGION', [
        'us-west-2'
      ],
      'AWS Region to use'
    )

    booleanParam(
      'PLAN_ONLY',
      true,
      'Perform terraform plan only, do not apply.'
    )

  }

  definition {
    cpsScm {
      scriptPath 'terraform/jenkins-service/Jenkinsfile'
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
