@SuppressWarnings("restriction")
public static void exportWar(IProject webProject) throws CoreException {
    WebComponentExportDataModelProvider modelProvider = new WebComponentExportDataModelProvider();

    IDataModel dataModel = DataModelFactory.createDataModel(modelProvider);
    dataModel.setBooleanProperty(IJ2EEComponentExportDataModelProperties.EXPORT_SOURCE_FILES, false);
    dataModel.setBooleanProperty(IJ2EEComponentExportDataModelProperties.OVERWRITE_EXISTING, true);
    dataModel.setStringProperty(IJ2EEComponentExportDataModelProperties.PROJECT_NAME, webProject.getName());

    dataModel.setStringProperty(IJ2EEComponentExportDataModelProperties.ARCHIVE_DESTINATION, webProject
            .getLocation().append(webProject.getName()).addFileExtension("war").toOSString());
    dataModel.setProperty(
            IJ2EEComponentExportDataModelProperties.COMPONENT,
            ComponentCore.createComponent(webProject));

    IDataModelOperation modelOperation = dataModel.getDefaultOperation();
    try {
        log.debug("Start  the export war operation");
        modelOperation.execute(null, null);
    }
    catch (ExecutionException e) {
        log.error("Error when exporting .war project", e);
    }
}