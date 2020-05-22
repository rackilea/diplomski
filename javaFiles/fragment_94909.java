...
    import com.fiot.ot.BuildConfig             <- should be
    import com.crashlytics.android.BuildConfig <- my IDE automatically imported 

    fun initFabric(context: Context) {
        val core = CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build()
        val kit = Crashlytics.Builder().core(core).build()
        Fabric.with(context, kit)
    }