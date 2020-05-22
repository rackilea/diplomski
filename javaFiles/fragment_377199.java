Object[] args = jp.getArgs();

ClmUserContextFactory contextFactory = (ClmUserContextFactory) args[0];
CloudObjectId objectId = (CloudObjectId) args[1];
Class<? extends CloudClass>[] relationClasses = null;
if (args.length == 3)
{
    relationClasses = (Class<? extends CloudClass>[]) args[2];
}