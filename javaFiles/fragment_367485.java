%module test

%include <std_string.i>

%typemap(jtype) bool foo "byte[]"
%typemap(jstype) bool foo "byte[]"
%typemap(jni) bool foo "jbyteArray"
%typemap(javaout) bool foo { return $jnicall; }
%typemap(in, numinputs=0) std::string& out (std::string temp) "$1=&temp;"
%typemap(argout) std::string& out {
  $result = JCALL1(NewByteArray, jenv, $1->size());
  JCALL4(SetByteArrayRegion, jenv, $result, 0, $1->size(), (const jbyte*)$1->c_str());
}
// Optional: return NULL if the function returned false
%typemap(out) bool foo {
  if (!$1) {
    return NULL;
  }
}

%inline %{
struct Bar {
  bool foo(std::string& out) {
    std::string s;
    s.push_back('H');
    s.push_back('o');
    s.push_back(0);
    s.push_back('l');
    s.push_back('a');
    out = s;
    return true;
  }
};
%}