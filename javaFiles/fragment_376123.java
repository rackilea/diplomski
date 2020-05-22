acceptor.setCloseOnDeactivation(true);
for (IoSession ss : acceptor.getManagedSessions().values()) {
  ss.close(true);
}
acceptor.unbind();
acceptor.dispose();