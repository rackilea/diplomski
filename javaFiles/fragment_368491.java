this.tree = new JTree(this.rootNode)
    {
        @Override
        protected void fireValueChanged(final TreeSelectionEvent e)
        {
            if (this.isValid())
                super.fireValueChanged(e);
            else
            {
                super.clearSelection();
            }

        }

    };