private iAmNotifying;
public void notify(Event e) 
{ 
    if (!iAmNotifying)
    {
        iAmNotifying = true;
        doTheActualNotification(e);
        iAmNotifying = false;
    }
}