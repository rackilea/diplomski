/**
   * When supervisorStrategy is not specified for an actor this
 * [[Decider]] is used by default in the supervisor strategy.
 * The child will be stopped when [[akka.actor.ActorInitializationException]],
 * [[akka.actor.ActorKilledException]], or [[akka.actor.DeathPactException]] is
 * thrown. It will be restarted for other `Exception` types.
 * The error is escalated if it's a `Throwable`, i.e. `Error`.
 */
final val defaultDecider: Decider = {
  case _: ActorInitializationException ⇒ Stop
  case _: ActorKilledException         ⇒ Stop
  case _: DeathPactException           ⇒ Stop
  case _: Exception                    ⇒ Restart
}

/**
 * When supervisorStrategy is not specified for an actor this
 * is used by default. OneForOneStrategy with decider defined in
 * [[#defaultDecider]].
 */
final val defaultStrategy: SupervisorStrategy = {
  OneForOneStrategy()(defaultDecider)
}