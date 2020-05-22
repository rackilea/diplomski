%module test

%{
#include <boost/filesystem/path.hpp>
#include <iostream>
%}

%typemap(jni) const boost::filesystem::path& "jstring"
%typemap(jstype) const boost::filesystem::path& "java.nio.file.Path"
%typemap(jtype) const boost::filesystem::path& "String"
%typemap(javain) const boost::filesystem::path& "$javainput.toString()"
%typemap(in) const boost::filesystem::path& (boost::filesystem::path tmp) {
    const char *str = JCALL2(GetStringUTFChars, jenv, $input, 0);
    tmp = str;
    $1 = &tmp;
    JCALL2(ReleaseStringUTFChars, jenv, $input, str);
}

%inline %{
    void test(const boost::filesystem::path& p) {
        std::cout << p << std::endl;
    }
%}