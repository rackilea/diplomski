xpath.setNamespaceContext(new NamespaceContext()
    {
        @Override
        public String getNamespaceURI(final String prefix)
        {
            if(prefix.equals("wadl"))
                return "http://research.sun.com/wadl/2006/10";
            else
                return null;
        }

        @Override
        public String getPrefix(final String namespaceURI)
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public Iterator getPrefixes(final String namespaceURI)
        {
            throw new UnsupportedOperationException();
        }
    });
    XPathExpression expression = xpath.compile("/wadl:application/wadl:resources/wadl:resource/@path");