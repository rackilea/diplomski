public class Application{
 List<FileType> exporters = new ArrayList<FileType>();
 public void addExporter(FileType fileExporter){
  exporters.add(fileExporter);
 }
 public void exportData(Object information){
   for(FileType exporter : exporters){
    exporter.export("d:\Export", information);
   }
 }
}