if(mStartForeground != null) {
    mStartForegroundArgs[0] = Convert.ToInt32(id);
    mStartForegroundArgs[1] = notification;
    //invoke via reflection (it may be different to invokeMethod?)
    mStartForeground.Invoke(instance, mStartForegroundArgs);
    return;
}