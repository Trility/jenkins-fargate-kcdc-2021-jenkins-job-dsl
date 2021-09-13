#!groovy

pipelineJob('Jenkins/Terraform/jenkins-base-infrastructure') {
  displayName 'jenkins-base-infrastructure'

  description 'Build and publish the Jenkins Base Infrastructure'

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

    booleanParam(
      'PLAN_ONLY',
      true,
      'Perform terraform plan only, do not apply.'
    )

  }

  definition {
    cpsScm {
      scriptPath 'terraform/jenkins-base-infrastructure/Jenkinsfile'
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
