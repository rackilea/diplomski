android {
    ...
    packagingOptions {
        pickFirst 'trust_root.bks' // add this
    }
}