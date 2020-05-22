void TemplateTable::checkcast() {
  transition(atos, atos);
  Label done, is_null, ok_is_subtype, quicked, resolved;
  __ testptr(rax, rax); // object is in rax
  __ jcc(Assembler::zero, is_null);

  // Get cpool & tags index
  __ get_cpool_and_tags(rcx, rdx); // rcx=cpool, rdx=tags array
  __ get_unsigned_2_byte_index_at_bcp(rbx, 1); // rbx=index
  // See if bytecode has already been quicked
  __ cmpb(Address(rdx, rbx,
                  Address::times_1,
                  Array<u1>::base_offset_in_bytes()),
          JVM_CONSTANT_Class);
  __ jcc(Assembler::equal, quicked);
  __ push(atos); // save receiver for result, and for GC
  call_VM(noreg, CAST_FROM_FN_PTR(address, InterpreterRuntime::quicken_io_cc));
  // vm_result_2 has metadata result
  __ get_vm_result_2(rax, r15_thread);
  __ pop_ptr(rdx); // restore receiver
  __ jmpb(resolved);

  // Get superklass in rax and subklass in rbx
  __ bind(quicked);
  __ mov(rdx, rax); // Save object in rdx; rax needed for subtype check
  __ movptr(rax, Address(rcx, rbx,
                       Address::times_8, sizeof(ConstantPool)));

  __ bind(resolved);
  __ load_klass(rbx, rdx);

  // Generate subtype check.  Blows rcx, rdi.  Object in rdx.
  // Superklass in rax.  Subklass in rbx.
  __ gen_subtype_check(rbx, ok_is_subtype);

  // Come here on failure
  __ push_ptr(rdx);
  // object is at TOS
  __ jump(ExternalAddress(Interpreter::_throw_ClassCastException_entry));

  // Come here on success
  __ bind(ok_is_subtype);
  __ mov(rax, rdx); // Restore object in rdx

  // Collect counts on whether this check-cast sees NULLs a lot or not.
  if (ProfileInterpreter) {
    __ jmp(done);
    __ bind(is_null);
    __ profile_null_seen(rcx);
  } else {
    __ bind(is_null);   // same as 'done'
  }
  __ bind(done);
}