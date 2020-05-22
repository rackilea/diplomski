(...)
User{id=5, info=UserInfo{info='Fifth'}}
execution(ClassNotFoundException java.lang.ClassNotFoundException.getUserInfo(Long))
Exception in thread "main" java.lang.reflect.InvocationTargetException
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
        at java.lang.reflect.Method.invoke(Unknown Source)
        at com.simontuffs.onejar.Boot.run(Boot.java:306)
        at com.simontuffs.onejar.Boot.main(Boot.java:159)
Caused by: java.lang.NullPointerException
        at de.scrum_master.a.a.a(Unknown Source)
        at de.scrum_master.app.b.getUserInfo(Unknown Source)
        at de.scrum_master.app.Application.main(Unknown Source)
        ... 6 more