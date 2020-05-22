void LIRGenerator::array_range_check(LIR_Opr array, LIR_Opr index,
                                    CodeEmitInfo* null_check_info, CodeEmitInfo* range_check_info) {
  CodeStub* stub = new RangeCheckStub(range_check_info, index, array);
  if (index->is_constant()) {
    cmp_mem_int(lir_cond_belowEqual, array, arrayOopDesc::length_offset_in_bytes(),
                index->as_jint(), null_check_info);
    __ branch(lir_cond_belowEqual, T_INT, stub); // forward branch
  } else {
    cmp_reg_mem(lir_cond_aboveEqual, index, array,
                arrayOopDesc::length_offset_in_bytes(), T_INT, null_check_info);
    __ branch(lir_cond_aboveEqual, T_INT, stub); // forward branch
  }
}