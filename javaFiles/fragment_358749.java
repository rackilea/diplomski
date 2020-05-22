(src/share/vm/runtime/thread.cpp)
3191   // Attach the main thread to this os thread
3192   JavaThread* main_thread = new JavaThread();
3193   main_thread->set_thread_state(_thread_in_vm);
3194   // must do this before set_active_handles and initialize_thread_local_storage
3195   // Note: on solaris initialize_thread_local_storage() will (indirectly)
3196   // change the stack size recorded here to one based on the java thread
3197   // stacksize. This adjusted size is what is used to figure the placement
3198   // of the guard pages.
3199   main_thread->record_stack_base_and_size();
3200   main_thread->initialize_thread_local_storage();