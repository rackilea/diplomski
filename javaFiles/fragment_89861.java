grant codeBase "<code base>" { 
   permission <type> "<target>", "<actions>"; 
   permission <type> "<target>", "<actions>"; 
   ... 
}; 

For eg. 
grant codeBase "http://geosim.cs.vt.edu/geosim/-" { 
  permission java.util.PropertyPermission "java.io.tmpdir", "read";
  ... 
};