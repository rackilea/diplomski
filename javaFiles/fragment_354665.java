// note: curly braces are MessageFormat-escaped

// ---

// trusted code
grant codeBase "{0}" '{'

    permission java.security.AllPermission;

'}';

// sandboxed code
grant codeBase "{1}" '{'

    // all permissions...
    permission java.security.AllPermission;

    // ...save for unsafe ones
    permission com.example.trusted.security.DeniedPermission "com.example.trusted.security.AllUnsafePermission";

    // ...with global reflective access via ReflectionGatekeeper
    permission com.example.trusted.security.SelectiveReflectPermission;

    // ...with the exception of system code and our own com.example.trusted package
    permission com.example.trusted.security.DeniedPermission "com.example.trusted.security.SelectiveReflectPermission:*!sun.*!*!*:*";
    permission com.example.trusted.security.DeniedPermission "com.example.trusted.security.SelectiveReflectPermission:*!com.sun.*!*!*:*";
    permission com.example.trusted.security.DeniedPermission "com.example.trusted.security.SelectiveReflectPermission:*!com.oracle.*!*!*:*";
    permission com.example.trusted.security.DeniedPermission "com.example.trusted.security.SelectiveReflectPermission:*!net.java.*!*!*:*";
    permission com.example.trusted.security.DeniedPermission "com.example.trusted.security.SelectiveReflectPermission:*!java.*!*!*:*";
    permission com.example.trusted.security.DeniedPermission "com.example.trusted.security.SelectiveReflectPermission:*!javax.*!*!*:*";
    // currently it's not possible to express both a base package _and_ its sub-packages in a single permission
    permission com.example.trusted.security.DeniedPermission "com.example.trusted.security.SelectiveReflectPermission:*!com.example.trusted!*!*:*";
    permission com.example.trusted.security.DeniedPermission "com.example.trusted.security.SelectiveReflectPermission:*!com.example.trusted.*!*!*:*";

'}';