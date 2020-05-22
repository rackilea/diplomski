try (CycSession session = CycSessionManager.getCurrentSession()) {
  // Some calls to KB API, Query API, etc...
}

// The session has been automatically closed. The next call will return a new session:
CycSession newSession = CycSessionManager.getCurrentSession();