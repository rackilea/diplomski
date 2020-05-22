.flatMap{ host ->
    userRepository.getUsers(PrefProvider.currentTourCode)
        .flatMap { 
            if (it.size) {
               return callSomething()
            }
            return callElse()
        }
 }