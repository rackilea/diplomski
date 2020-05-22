public class TableUtilities {

    private static WeakHashMap<JTable, FilterSupport> mapFilters = new WeakHashMap(25);

    public static void installFilterSupport(JTable table, IFilterListener listener, KeyStroke escapeKey) {
        FilterSupport support = new FilterSupport(table, listener, escapeKey);
        mapFilters.put(table, support);
    }

    public static void uninstallFilterSupport(JTable table) {
        FilterSupport support = mapFilters.remove(table);
        if (support != null) {
            support.uninstall();
        }
    }

    protected static class FilterSupport implements IFilterSupport {

        private JViewport viewport;
        private JTable table;
        private JTextField searchField;
        private Timer filterTimer;

        private HierarchyListener hierarchyListener;
        private ChangeListener changeListener;
        private IFilterListener filterListener;

        public FilterSupport(JTable table, IFilterListener listener, KeyStroke escapeKey) {
            this.table = table;
            this.filterListener = listener;
            table.setFillsViewportHeight(true);

            hierarchyListener = new HierarchyListener() {
                @Override
                public void hierarchyChanged(HierarchyEvent e) {
                    long flags = e.getChangeFlags();
                    if ((flags & HierarchyEvent.PARENT_CHANGED) != 0) {
                        if (e.getChanged().equals(table)) {
                            JTable table = (JTable) e.getChanged();
                            if (e.getChangedParent() instanceof JViewport) {
                                if (table.getParent() == null) {
                                    uninstall();
                                } else {
                                    install();
                                }
                            }
                        }
                    }
                }
            };
            changeListener = new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    JViewport viewport = (JViewport) e.getSource();
                    Rectangle viewRect = viewport.getViewRect();
                    searchField.setSize(searchField.getPreferredSize());
                    int x = (viewRect.x + viewRect.width) - searchField.getWidth();
                    int y = viewRect.y;
                    searchField.setLocation(x, y);
                }
            };

            table.addHierarchyListener(hierarchyListener);

            searchField = new JTextField(20);
            searchField.setVisible(false);
            searchField.getDocument().addDocumentListener(new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent e) {
                    filterChanged();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    filterChanged();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    filterChanged();
                }
            });

            searchField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    cancelField();
                }
            });

            filterTimer = new Timer(250, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    applyFilter();
                }
            });
            filterTimer.setRepeats(false);

            table.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    if (Character.isLetterOrDigit(e.getKeyChar())) {
                        searchField.setVisible(true);
                        table.revalidate();
                        table.repaint();
                        // ?? Should this maintain the current filter value?
                        searchField.setText(null);
                        searchField.requestFocusInWindow();
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                searchField.dispatchEvent(e);
                            }
                        });

                    }
                }

            });

            Action escapeAction = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cancelField();
                }
            };

            bindKeyStrokeTo(table, JComponent.WHEN_FOCUSED, "clear", escapeKey, escapeAction);
            bindKeyStrokeTo(searchField, JComponent.WHEN_FOCUSED, "clear", escapeKey, escapeAction);

        }

        protected void cancelField() {
            searchField.setVisible(false);
            table.requestFocusInWindow();
            table.revalidate();
            table.repaint();
            if (filterListener != null) {
                filterListener.filterCancelled(table, this);
            }
        }

        public void filterChanged() {
            filterTimer.restart();
        }

        protected void applyFilter() {

            if (filterListener != null) {
                filterListener.filterChanged(table, searchField.getText());
            }

        }

        protected void uninstall() {
            filterTimer.stop();
            if (viewport != null) {
                if (changeListener != null) {
                    viewport.removeChangeListener(changeListener);
                }
                table.remove(searchField);
                searchField.setVisible(false);
            }
            viewport = null;
        }

        protected void install() {
            if (viewport != null) {
                uninstall();
            }
            Container parent = table.getParent();
            if (parent instanceof JViewport) {
                viewport = (JViewport) parent;
                viewport.addChangeListener(changeListener);
                table.add(searchField);
            }
        }

        @Override
        public String getFilter() {
            return searchField.getText();
        }

        @Override
        public void setFilter(String filter) {
            searchField.setText(filter);
        }

    }

    public static void bindKeyStrokeTo(JComponent parent, int condition, String name, KeyStroke keyStroke, Action action) {
        InputMap im = parent.getInputMap(condition);
        ActionMap am = parent.getActionMap();

        im.put(keyStroke, name);
        am.put(name, action);
    }

    public static interface IFilterSupport {

        public String getFilter();

        public void setFilter(String filter);

    }

    public static interface IFilterListener {

        public void filterChanged(JTable table, String filter);

        public void filterCancelled(JTable table, IFilterSupport support);
    }

}