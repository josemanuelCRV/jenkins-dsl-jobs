#!groovy

multibranchPipelineJob('example') {

    triggers {
        periodic(1)
    }

    branchSources {
        git {
            id = UUID.nameUUIDFromBytes(repo.getBytes())
            remote('https://github.com/josemanuelCRV/octo-repo.git')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(2)
        }
    }
}
