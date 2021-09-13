#!groovy

def libVersions = new LibraryVersions()

folder("Jenkins") {
  displayName("Jenkins")
  description("Jenkins Deployment Jobs")
  properties {
    folderLibraries {
      libraries {
        libraryConfiguration {
          name "jenkins-library"
          implicit true
          defaultVersion libVersions.getJenkinsLibraryVersion()
          retriever {
            modernSCM {
              scm {
                git {
                  id "jenkins-library"
                  remote "https://github.com/Trility/jenkins-fargate-kcdc-2021-jenkins-library.git"
                }
              }
            }
          }
        }
      }
    }
  }
}

folder("Jenkins/Containers") {
  displayName("Containers")
  description("Jenkins Containers for Deployment")
}

folder("Jenkins/Terraform") {
  displayName("Terraform")
  description("Jenkins Terraform for Deployment")
}

folder("Jenkins/Containers/Workers") {
  displayName("Workers")
  description("Containers for Jenkins Workers")
}
