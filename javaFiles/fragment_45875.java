C:\Users\VonC\prog\git>git clone https://github.com/eclipse/jgit
Cloning into 'jgit'...
remote: Counting objects: 37854, done.
remote: Compressing objects: 100% (7743/7743), done.
remote: Total 37854 (delta 22009), reused 34367 (delta 18831)
Receiving objects: 100% (37854/37854), 6.73 MiB | 1.37 MiB/s, done.
Resolving deltas: 100% (22009/22009), done.

C:\Users\VonC\prog\git>cd jgit

C:\Users\VonC\prog\git\jgit>grep -nrHI "setKnownHosts" *
org.eclipse.jgit/src/org/eclipse/jgit/transport/JschConfigSessionFactory.java:262:                              sch.setKnownHosts(in);