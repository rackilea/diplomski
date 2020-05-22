dependencies{
  ...
  optLibs 'javax.mail:mail:1.4.7'
  optLibs 'javax.activation:activation:1.1.1'
  compile 'foo'
  runtime 'bar'
  ...
  providedCompile.extendsFrom(optLibs)
}