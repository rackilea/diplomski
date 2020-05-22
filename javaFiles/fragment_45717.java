(void)registerDefaultSubscribers 
{
  [_defaultNotificationSubscribers removeAllObjects];
  [_defaultNotificationSubscribers addObjectsFromArray:[self createDefaultSubscribers]];
  …
}