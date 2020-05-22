%module test

%include "test.hh"

%template(ABar) NS1::Bar< NS1::A >;
%template(BBar) NS1::Bar<NS1::B>;

%extend NS1::Bar<NS1::A> {
    %template() Bar<NS1::A>;
    %template() Bar<NS1::B>;
};

%extend NS1::Bar<NS1::B> {
    %template() Bar<NS1::B>;
};