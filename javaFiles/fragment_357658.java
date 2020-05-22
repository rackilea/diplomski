>> foo = java.lang.String('foo');
>> builtin('length', [foo foo])
ans =
     2
>> builtin('length', [foo])
ans =
     1
>> length([foo])
ans =
     3
>>