project.accept(new IResourceProxyVisitor()
  {
    @Override
    public boolean visit(IResourceProxy proxy) throws CoreException
    {
       if ("Foo.java").equals(proxy.getName))
        {
          IPath workspacePath = proxy.requestFullPath();
          // TODO deal with path
          // Alternative
          IResource resource = proxy.requestResource();
        }
    }
  });