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
