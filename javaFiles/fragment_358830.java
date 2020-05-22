void TemplateTable::iaload() {
  transition(itos, itos);
  // rax: index
  // rdx: array
  index_check(rdx, rax); // kills rbx                              --------------
  __ access_load_at(T_INT, IN_HEAP | IS_ARRAY, rax,                             |
                    Address(rdx, rax, Address::times_4,                         |
                            arrayOopDesc::base_offset_in_bytes(T_INT)),         |
                    noreg, noreg);                                              |
}                                                                               |
                                                                                |
void TemplateTable::index_check(Register array, Register index) {             <--
  // Pop ptr into array                                                          
  __ pop_ptr(array);                                                             
  index_check_without_pop(array, index);                           --------------
}                                                                               |
                                                                                |
void TemplateTable::index_check_without_pop(Register array, Register index) { <--
  // destroys rbx
  // check array
  __ null_check(array, arrayOopDesc::length_offset_in_bytes());
  // sign extend index for use by indexed load
  __ movl2ptr(index, index);
  // check index
  __ cmpl(index, Address(array, arrayOopDesc::length_offset_in_bytes()));
  if (index != rbx) {
    // ??? convention: move aberrant index into rbx for exception message
    assert(rbx != array, "different registers");
    __ movl(rbx, index);
  }
  Label skip;
  __ jccb(Assembler::below, skip);
  // Pass array to create more detailed exceptions.
  __ mov(NOT_LP64(rax) LP64_ONLY(c_rarg1), array);
  __ jump(ExternalAddress(Interpreter::_throw_ArrayIndexOutOfBoundsException_entry));  !!!
  __ bind(skip);
}