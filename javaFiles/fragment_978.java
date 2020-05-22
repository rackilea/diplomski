final DataFlavor flavor =new DataFlavor(TreePath.class, "treePath");
    TransferHandler treeHandler = new TransferHandler() {
        DataFlavor[] pathFlavour = new DataFlavor[] 
                  {flavor};

        /** 
         * @inherited <p>
         */
        @Override
        protected Transferable createTransferable(JComponent c) {
            JTree tree = (JTree) c;
            final TreePath path = tree.getSelectionPath();
            Transferable transferable = new Transferable() {

                @Override
                public DataFlavor[] getTransferDataFlavors() {
                    return pathFlavour;
                }

                @Override
                public boolean isDataFlavorSupported(DataFlavor flavor) {
                    return pathFlavour[0].equals(flavor);
                }

                @Override
                public Object getTransferData(DataFlavor flavor)
                        throws UnsupportedFlavorException, IOException {
                    return path;
                }

            };
            return transferable;
        }

        public int getSourceActions(JComponent c) {
            return COPY;
        }

    };
    tree.setTransferHandler(treeHandler);
    JLabel labelTarget = new JLabel("I'm a drop target!");
    TransferHandler labelHandler = new TransferHandler() {

        /** 
         * @inherited <p>
         */
        @Override
        public boolean importData(JComponent comp, Transferable t) {
            try {
                LOG.info("import from: " +  t.getTransferData(flavor));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }

        /** 
         * @inherited <p>
         */
        @Override
        public boolean canImport(JComponent comp,
                DataFlavor[] transferFlavors) {
            return true;
        }

    };
    labelTarget.setTransferHandler(labelHandler);