try {
        arCoreSession = Session(this)

        val config = Config(arCoreSession)
        if (!arCoreSession.isSupported(config)) {
            Logger.d("ARCore not installed")
        } else {
            arCoreSession.configure(config)
        }
    } catch (ex: Throwable) {
        Logger.d("ARCore not installed")
    }