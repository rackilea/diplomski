%module test

%include "test.hh"

%template(ABar) NS1::Bar< NS1::A >;
%template(BBar) NS1::Bar<NS1::B>;

namespace NS1 {

%extend Bar< A > {
    %template(ABar) Bar<A>;
    %template(ABar) Bar<B>;
};

%extend Bar<B> {
    %template(BBar) Bar<B>;
};
} // NS1