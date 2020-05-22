buildTypes {
    debug {
      applicationIdSuffix ".d"
      buildConfigField "String", "SERVER_URL", '"http://test.this-is-so-fake.com"'
    }

    release {
      buildConfigField "String", "SERVER_URL", '"http://prod.this-is-so-fake.com"'
    }

    staging.initWith(buildTypes.release)

    staging {
        applicationIdSuffix ".stage"
        debuggable true
        buildConfigField "String", "SERVER_URL", '"http://stage.this-is-so-fake.com"'
    }
}