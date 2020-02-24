#!groovy

UUID uuid = UUID.fromString("dd847135-8391-4f66-a54c-7f8781dc3119")

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
