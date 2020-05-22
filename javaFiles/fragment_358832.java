if (_throw_index_out_of_bounds_exception) {
    stub_id = Runtime1::throw_index_exception_id;
  } else {
    stub_id = Runtime1::throw_range_check_failed_id;
    ce->store_parameter(_array->as_pointer_register(), 1);
  }
  __ call(RuntimeAddress(Runtime1::entry_for(stub_id)));