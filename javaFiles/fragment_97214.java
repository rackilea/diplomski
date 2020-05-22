sourceSets {
    main {
        java {
            include 'com/ourcompany/somepackage/activityadapter/**'
            include 'com/ourcompany/someotherpackage/**'
            exclude 'com/ourcompany/someotherpackage/polling/**'
        }
    }
}