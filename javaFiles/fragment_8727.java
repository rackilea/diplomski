RatpackServer.start(serverSpec -> serverSpec
      .serverConfig(config -> config
        .baseDir(BaseDir.find()) // locates the .ratpack file
        .yaml("postgres.yaml") // finds file relative to directory containing .ratpack file
        .require("/db", HikariConfig.class) // bind props from yaml file to HikariConfig class
      ).registry(Guice.registry(bindings -> bindings
        .module(HikariModule.class) // this will use HikariConfig to configure the module
      )).handlers(...));