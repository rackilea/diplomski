CASE(_checkcast):
      if (STACK_OBJECT(-1) != NULL) {
        VERIFY_OOP(STACK_OBJECT(-1));
        u2 index = Bytes::get_Java_u2(pc+1);
        if (ProfileInterpreter) {
          // needs Profile_checkcast QQQ
          ShouldNotReachHere();
        }
        // Constant pool may have actual klass or unresolved klass. If it is
        // unresolved we must resolve it
        if (METHOD->constants()->tag_at(index).is_unresolved_klass()) {
          CALL_VM(InterpreterRuntime::quicken_io_cc(THREAD), handle_exception);
        }
        Klass* klassOf = (Klass*) METHOD->constants()->slot_at(index).get_klass();
        Klass* objKlassOop = STACK_OBJECT(-1)->klass(); //ebx
        //
        // Check for compatibilty. This check must not GC!!
        // Seems way more expensive now that we must dispatch
        //
        if (objKlassOop != klassOf &&
            !objKlassOop->is_subtype_of(klassOf)) {
          ResourceMark rm(THREAD);
          const char* objName = objKlassOop->external_name();
          const char* klassName = klassOf->external_name();
          char* message = SharedRuntime::generate_class_cast_message(
            objName, klassName);
          VM_JAVA_ERROR(vmSymbols::java_lang_ClassCastException(), message);
        }
      } else {
        if (UncommonNullCast) {
            //              istate->method()->set_null_cast_seen();
            // [RGV] Not sure what to do here!

        }
      }
      UPDATE_PC_AND_CONTINUE(3);