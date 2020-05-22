@Bean(initMethod = "init")
public MainContentPane mainContentPane() {...}

@Bean
public LockScreen lockScreen() {...}

@Bean
public LockScreenLockedController lockScreenLockedController() {...}

@Bean
public UserStateBinder userStateBinder() {...}

@Bean
public SessionHandler sessionHandler() {...}