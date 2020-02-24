#!groovy

multibranchPipelineJob('example') {

    triggers {
        periodic(1)
    }

    branchSources {
        git {
            remote('https://github.com/josemanuelCRV/octo-repo.git')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(2)
        }
    }
}








project_name = "jenkins-pipeline-demo"
repo = "https://github.com/josemanuelCRV/octo-repo.git"
repo_name = "octo-repo"

multibranchPipelineJob('example') {
    definition {
        triggers {
            scm('H/1 * * * *')
        }

        cpsScm {
            scm {
                git {
                    remote {
                        name(repo_name)
                        url(repo)
                    }
                }
                scriptPath("Jenkinsfile")
            }
        }
        
    }



    branchSources {
        git {
            id('123456789') // IMPORTANT: use a constant and unique identifier
            remote('https://github.com/jenkinsci/job-dsl-plugin.git')
            credentialsId('github-ci')
            includes('JENKINS-*')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}