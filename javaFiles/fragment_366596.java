jvmtiError
JvmtiEnv::SuspendThread(JavaThread* java_thread) {
  // don't allow hidden thread suspend request.
  if (java_thread->is_hidden_from_external_view()) {
    return (JVMTI_ERROR_NONE);
  }

  {
    MutexLockerEx ml(java_thread->SR_lock(), Mutex::_no_safepoint_check_flag);
    if (java_thread->is_external_suspend()) {
      // don't allow nested external suspend requests.
      return (JVMTI_ERROR_THREAD_SUSPENDED);
    }
    if (java_thread->is_exiting()) { // thread is in the process of exiting
      return (JVMTI_ERROR_THREAD_NOT_ALIVE);
    }
    java_thread->set_external_suspend();
  }

  if (!JvmtiSuspendControl::suspend(java_thread)) {
    // the thread was in the process of exiting
    return (JVMTI_ERROR_THREAD_NOT_ALIVE);
  }
  return JVMTI_ERROR_NONE;
} /* end SuspendThread */


bool JvmtiSuspendControl::suspend(JavaThread *java_thread) {
  // external suspend should have caught suspending a thread twice

  // Immediate suspension required for JPDA back-end so JVMTI agent threads do
  // not deadlock due to later suspension on transitions while holding
  // raw monitors.  Passing true causes the immediate suspension.
  // java_suspend() will catch threads in the process of exiting
  // and will ignore them.
  java_thread->java_suspend();

  // It would be nice to have the following assertion in all the time,
  // but it is possible for a racing resume request to have resumed
  // this thread right after we suspended it. Temporarily enable this
  // assertion if you are chasing a different kind of bug.
  //
  // assert(java_lang_Thread::thread(java_thread->threadObj()) == NULL ||
  //   java_thread->is_being_ext_suspended(), "thread is not suspended");

  ...