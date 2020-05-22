fun acceptHandler(handler:Handler<String>){}

acceptHandler(Handler { println("Hello: $it")})

acceptHandler({ println("Hello: $it")})

acceptHandler { println("Hello: $it")}