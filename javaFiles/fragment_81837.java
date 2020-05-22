ActorSystem as1 = ActorSystem.create("actor1");
ActorRef ar1 = as1.actorOf(Props.create(Hello.class), "ar1");
ActorRef ar2 = as1.actorOf(Props.create(Hello.class), "ar2");
List<String> routees = Arrays.asList(ar1, ar2);
ActorRef routerActorRef = as1.actorOf(new RoundRobinGroup(routees).props(), "router");
System.out.println("Start to say hello!");

FiniteDuration delay = FiniteDuration.create(10, TimeUnit.MINUTES);
FiniteDuration initialDelay = FiniteDuration.create(2, TimeUnit.MINUTES);
as1.scheduler().schedule(initialDelay, delay, routerActorRef, "Bob", as1.dispatcher(), ActorRef.noSender())

as1.scheduler().schedule(initialDelay, delay, routerActorRef, "John", as1.dispatcher(), ActorRef.noSender())

System.out.println("Finish to say hello!”);