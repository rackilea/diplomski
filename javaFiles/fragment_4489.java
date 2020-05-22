IGuestProcess process = null;

ISession session = manager.getSessionObject(); //VirtualBoxManager

machine.lockMachine(session, LockType.Shared); //IMachine

IConsole console = session.getConsole();

IGuest guest = console.getGuest();

IGuestSession guestSession = guest.createSession("registerdUserWithRights", "hisPasswd", "", "");

Long time = 100000L;

GuestSessionWaitResult result = guestSession.waitFor(time, time);       

List<String> argumentsForProcess = Arrays.asList("--disabled-password", "--gecos", "'" + name + "'", username);

if(result == GuestSessionWaitResult.Start)
    createUser = guestSession.processCreate("/usr/sbin/adduser", argumentsForProcess, null, null, 0L);


ProcessWaitResult waitResult = process.waitFor(1L, time);

if(waitResult == ProcessWaitResult.Start)
    System.out.println("started");
guestSession.close();
session.unlockMachine();