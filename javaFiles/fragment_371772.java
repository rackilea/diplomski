if (JAVA_SAMPLE == type) {
    if (thread_state_in_java(thread)) {
      ret = sample_thread_in_java(thread, frames, max_frames);
    }
  } else {
    assert(NATIVE_SAMPLE == type, "invariant");
    if (thread_state_in_native(thread)) {
      ret = sample_thread_in_native(thread, frames, max_frames);
    }
  }