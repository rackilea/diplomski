JspConfigDescriptor j = new JspConfigDescriptor()
    {

        @Override
        public Collection<TaglibDescriptor> getTaglibs()
        {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Collection<JspPropertyGroupDescriptor> getJspPropertyGroups()
        {
            Collection<JspPropertyGroupDescriptor> c = new ArrayList<JspPropertyGroupDescriptor>();
            JspPropertyGroupDescriptorImpl pgDescriptor = new JspPropertyGroupDescriptorImpl();
            pgDescriptor.setIsXml(Boolean.TRUE.toString());
            pgDescriptor.getUrlPattern().add("/js/generated/*");
            pgDescriptor.setElIgnored(Boolean.FALSE.toString());
            pgDescriptor.setPageEncoding("UTF-8");
            c.add(pgDescriptor);
            return null;
        }
    };
    servletContext.setJspConfigDescriptor(j);