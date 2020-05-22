@Override
public void setAttribute(String name, Object value, boolean notify) {
    super.setAttribute(name, value, notify);
    ((DataGridManager)this.getManager()).getCacheManager().getCache("sessions").put(this.getIdInternal(), this);
}

@Override
public void removeAttribute(String name, boolean notify) {
    super.removeAttribute(name, notify);
    ((DataGridManager)this.getManager()).getCacheManager().getCache("sessions").put(this.getIdInternal(), this);
}