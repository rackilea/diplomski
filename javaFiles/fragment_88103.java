object MyApp extends App {

  val config = ConfigData(args(0))

  val injector = Guice.createInjector(module(config))
  val service = injector.getInstance(classOf[InfrastructureService])

  println("The service name is:" + service.kbService.config.configName)

}


case class module(config: ConfigData) extends AbstractModule {
  def configure(): Unit = {
    bind(classOf[ConfigData]).toInstance(config)
  }
}

case class ConfigData(val configName: String)

class KbService @Inject() (val config: ConfigData)

class InfrastructureService @Inject() (val kbService: KbService)