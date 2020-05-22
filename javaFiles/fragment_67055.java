includeTargets << new File("$seleniumRcPluginDir/scripts/_SeleniumConfig.groovy")
includeTargets << new File("$seleniumRcPluginDir/scripts/_SeleniumServer.groovy")

eventTestPhaseStart = { phase ->
    if(isAcceptance(phase)){
      startSeleniumServer()
    }
}
eventTestPhaseEnd = { phase ->
    if(isAcceptance(phase)){
      stopSeleniumServer()
    }
}
isAcceptance = { phase->
     phase?.contains("acceptance");
}