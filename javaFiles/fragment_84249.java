== Incompatibilities ==

The protected method LogFactory.getContextClassLoader has been reverted to pre-1.1
behaviour. In earlier releases, this method did not use an AccessController when
obtaining the context classloader. In version 1.1 it did. In this release, it has
reverted to not using an AccessController; any user-level code that needs to obtain
a context classloader should itself create an AccessController, and call the
LogFactory.getContextClassLoader method via the doPrivileged method. This fixes a
potential security issue, where untrusted code could get access to the context
classloader if a signed Commons Logging library was in the classpath.