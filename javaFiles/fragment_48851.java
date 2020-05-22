TableViewer viewer = new TableViewer(.....);

TableViewerColumn col1 = new TableViewerColumn(viewer, SWT.LEAD);

col1.setLabelProvider(column label provider for col 1);

col1.setEditingSupport(editing support for col 1);

... repeat for other columns