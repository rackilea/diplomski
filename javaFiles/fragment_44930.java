%module test

%{
#include "test.h"
%}

// Hide the default new_instance
%ignore new_instance;
%include "test.h"
// Pretend our wrapper specific "overload" was called new_instance all along
%rename(new_instance) new_instance_overload;
// Don't leak our new instance
%newobject new_instance;

// Declare, define and wrap a special version of new_instance
%inline %{
    instance_t new_instance_overload(const char* name) {
        instance_t result = NULL;
        const int err = new_instance(name, &result);
        if (err) {
            // See later on/other Q for cross language exception example
        }
        return result;
    }
%}