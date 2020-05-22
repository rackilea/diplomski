%javamethodmodifiers foo_array_getitem "private";
%ignore foo_array_setitem;
%ignore delete_foo_array;
%ignore new_foo_array;
%include <carrays.i>
%array_functions(struct Foo, foo_array);