mvn dependency:tree -Dverbose -Dincludes=commons-collections

The verbose flag instructs the dependency tree to display conflicting dependencies that were omitted from the resolved dependency tree. In this case, the goal outputs:

[INFO] [dependency:tree]
[INFO] org.apache.maven.plugins:maven-dependency-plugin:maven-plugin:2.0-alpha-5-SNAPSHOT
[INFO] +- org.apache.maven.reporting:maven-reporting-impl:jar:2.0.4:compile
[INFO] |  \- commons-validator:commons-validator:jar:1.2.0:compile
[INFO] |     \- commons-digester:commons-digester:jar:1.6:compile
[INFO] |        \- (commons-collections:commons-collections:jar:2.1:compile - omitted for conflict with 2.0)
[INFO] \- org.apache.maven.doxia:doxia-site-renderer:jar:1.0-alpha-8:compile
[INFO]    \- org.codehaus.plexus:plexus-velocity:jar:1.1.3:compile
[INFO]       \- commons-collections:commons-collections:jar:2.0:compile
Thus we can see that Commons Collections 2.0 was chosen over 2.1 since it is nearer, and by default Maven resolves version conflicts with a nearest-wins strategy.

More specifically, in verbose mode the dependency tree shows dependencies that were omitted for: being a duplicate of another; conflicting with another's version and/or scope; and introducing a cycle into the dependency tree.