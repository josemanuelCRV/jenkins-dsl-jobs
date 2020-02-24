#!groovy

multibranchPipelineJob('example') {

    def repo = 'https://github.com/josemanuelCRV/octo-repo.git'

    triggers {
        periodic(1)
    }

    branchSources {
        git {
            id = UUID.nameUUIDFromBytes(repo.getBytes())
            remote(repo)
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(2)
        }
    }
}
