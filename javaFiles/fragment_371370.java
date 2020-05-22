class CustomApplicationLoader extends GuiceApplicationLoader {

    override protected def builder(context: Context): GuiceApplicationBuilder = {
        val builder = initialBuilder.in(context.environment).overrides(overrides(context): _*)
        context.environment.mode match {
            case Prod =>
                // start mode
                val prodConf = Configuration(ConfigFactory.load("prod.conf"))
                builder.loadConfig(prodConf ++ context.initialConfiguration).bindings(new ProdModule());
            case Dev =>
                // run mode
                val devConf = Configuration(ConfigFactory.load("dev.conf"))
                builder.loadConfig(devConf ++ context.initialConfiguration).bindings(new DevModule());
            case Test =>
                // test mode
                val testConf = Configuration(ConfigFactory.load("test.conf"))
                builder.loadConfig(testConf ++ context.initialConfiguration).bindings(new TestModule());
        }
    }
}