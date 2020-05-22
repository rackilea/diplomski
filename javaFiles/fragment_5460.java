protected Component newBreadCrumbComponent(final String id, final long index, final int total,
    final IBreadCrumbParticipant breadCrumbParticipant)
{
    boolean enableLink = getEnableLinkToCurrent() || (index < (total - 1));
    return new AjaxBreadCrumbComponent(id, getSeparatorMarkup(), index, this,
        breadCrumbParticipant, enableLink);
}