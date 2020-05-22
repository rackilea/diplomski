mountResource("/help", new ResourceReference("helpres") {
                private static final long serialVersionUID = 1L;

                @Override
                public IResource getResource() {
                    return new DirectoryResolverResource(helpDir, "help");
                }
            });