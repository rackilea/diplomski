Model model = . . . ;
model.enterCriticalSection(Lock.READ) ;  // or Lock.WRITE
try {
    ... perform actions on the model ...
    ... obey contract - no update operations if a read lock
} finally {
    model.leaveCriticalSection() ;
}