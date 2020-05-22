{ 'func_name': 'has_no_letters',
  'num_args': 1,
  'kwargs': [],
  'codez': [
    ('get_attr', 'tmp_a', 'arg_0', 'upper'),  # tmp_a = arg_0.upper
    ('func_call', 'tmp_b', 'tmp_a', []),  # tmp_b = tmp_a() # tmp_b = arg_0.upper()
    ('get_attr', 'tmp_c', 'arg_0', 'lower'),
    ('func_call', 'tmp_d', 'tmp_c', []),
    ('get_global', 'tmp_e', '=='),
    ('func_call', 'tmp_f', 'tmp_e', ['tmp_b', 'tmp_d']),
    ('return', 'tmp_f'),
  ]
}