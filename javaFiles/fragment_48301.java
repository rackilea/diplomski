/**
 * Exports data provided by a {@link IDataProvider} as described by {@link IExportableColumn}s. This interface is used by
 * {@link ExportToolbar} to provide the export functionality.
 * @param <T>
 *      The type of each row of data provided by the {@link IDataProvider}.
 *
 * @author Jesse Long
 * @see ExportToolbar
 * @see IExportableColumn
 */

public interface<T> IDataExporter extends IClusterable
{
    ...
    /**
     * Exports the data provided by the {@link IDataProvider} to the {@link OutputStream}.
     *
     * @param dataProvider
     *      The {@link IDataProvider} from which to retrieve the data.
     * @param columns
     *      The {@link IExportableColumn} to use to describe the data.
     * @param outputStream
     *      The {@link OutputStream} to which to write the exported data.
     * @throws IOException If an error occurs.
     */
    void exportData(IDataProvider<T> dataProvider, List<IExportableColumn<T, ?, ?>> columns, OutputStream outputStream)
        throws IOException;
}