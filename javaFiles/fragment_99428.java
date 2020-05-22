@Bean(initMethod = "init")
public MainContentPane mainContentPane() {...}

@Bean
@DependsOn("lockScreenLockedController")
public LockScreen lockScreen() {...}

@Bean
@DependsOn("userStateBinder")
public LockScreenLockedController lockScreenLockedController() {...}

@Bean
@DependsOn("sessionHandler")
public UserStateBinder userStateBinder() {...}

@Bean
@DependsOn("mainContentPane")
public SessionHandler sessionHandler() {...}