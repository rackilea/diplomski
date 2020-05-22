import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ooxml.POIXMLRelation;
import static org.apache.poi.ooxml.POIXMLTypeLoader.DEFAULT_XML_OPTIONS;

import org.apache.poi.openxml4j.opc.*;

import org.apache.xmlbeans.XmlOptions;

import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.SpreadsheetVersion;

import org.apache.poi.xssf.model.MapInfo;
import org.apache.poi.xssf.usermodel.*;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.*;

import javax.xml.namespace.QName;

import java.util.List;

public class CreateExcelWithXmlMap {

 private static CTMap addMap(MapInfo mapInfo, String mapName, String rootElement, String schemaId) {
  CTMapInfo cTMapInfo = mapInfo.getCTMapInfo();
  long id = 1;
  for (CTMap map : cTMapInfo.getMapList()) {
   if (map.getID() >= id) id = map.getID() + 1;
  }
  CTMap map = cTMapInfo.addNewMap();
  map.setID(id);
  map.setName(mapName);
  map.setRootElement(rootElement);
  map.setSchemaID(schemaId);
  map.setAutoFit(true);
  map.setAppend(false);
  map.setPreserveSortAFLayout(true);
  map.setPreserveFormat(true);
  return map;
 }

 private static int addSchema(MapInfo mapInfo, InputStream schemaIn, String schemaIdPrefix) throws Exception {
  CTMapInfo cTMapInfo = mapInfo.getCTMapInfo();
  List<CTSchema> schemas = cTMapInfo.getSchemaList();
  CTSchema[] schemaArray = new CTSchema[schemas.size()+1];
  int i = 0;
  int id = 1;
  for (CTSchema schema : schemas) {
   schemaArray[i++] = schema;
   if (schema.getID().startsWith(schemaIdPrefix)) id++;
  }
  CTSchema schema = CTSchema.Factory.parse(schemaIn);
  schema.setID(schemaIdPrefix + id);
  schemaArray[i] = schema;
  cTMapInfo.setSchemaArray(schemaArray);
  return id;
 }

 private static void writeMapInfoMinContent(PackagePart part) throws Exception {
  CTMapInfo cTMapInfo = MapInfoDocument.Factory.newInstance().addNewMapInfo();
  cTMapInfo.setSelectionNamespaces("");
  XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
  xmlOptions.setSaveSyntheticDocumentElement(new QName(CTMapInfo.type.getName().getNamespaceURI(), "MapInfo"));
  OutputStream out = part.getOutputStream();
  cTMapInfo.save(out, xmlOptions);
  out.close();
 }

 private static MapInfo createMapInfo(XSSFWorkbook workbook) throws Exception {
  MapInfo mapInfo = workbook.getMapInfo();
  if (mapInfo != null) {
   return mapInfo;
  } else {
   OPCPackage oPCPackage = workbook.getPackage();
   PackagePartName partName = PackagingURIHelper.createPartName("/xl/xmlMaps.xml");
   PackagePart part = oPCPackage.createPart(partName, "application/xml");
   writeMapInfoMinContent(part);
   mapInfo = new MapInfo(part);
   String rId = workbook.addRelation(null, new XSSFXmlMapsRelation(), mapInfo).getRelationship().getId();
  }
  return mapInfo;
 }

 public static void main(String[] args) throws Exception {

  String schemaFilePath = "./class.xsd";
  String workbookFilePath = "./ExcelWithXMLMap.xlsx";

  XSSFWorkbook workbook = new XSSFWorkbook();

  MapInfo mapInfo = createMapInfo(workbook);
  InputStream schemaIn = new FileInputStream(schemaFilePath);
  int schemaId = addSchema(mapInfo, schemaIn, "Schema");
  CTMap cTMap = addMap(mapInfo, "class_Map", "class", "Schema"+schemaId);
  XSSFMap xssfMap = new XSSFMap(cTMap, mapInfo);
  //ToDo: update private Map<Integer, XSSFMap> maps in MapInfo 

  String[] headers = new String[]{"rollno", "firstname", "lastname", "nickname", "marks"};
  //ToDo: get headers from schema

  XSSFSheet sheet = workbook.createSheet();
  XSSFTable table = sheet.createTable(new AreaReference("A1:E2", SpreadsheetVersion.EXCEL2007));
  table.setDisplayName("class");
  table.getCTTable().addNewTableStyleInfo();
  XSSFTableStyleInfo style = (XSSFTableStyleInfo)table.getStyle();
  style.setName("TableStyleMedium2");
  style.setShowColumnStripes(false);
  style.setShowRowStripes(true);
  table.getCTTable().setTableType(STTableType.XML);
  int i = 0;
  for (CTTableColumn ctTableColumn : table.getCTTable().getTableColumns().getTableColumnList()) {
   ctTableColumn.setUniqueName(headers[i]);
   CTXmlColumnPr xmlColumnPr = ctTableColumn.addNewXmlColumnPr();
   xmlColumnPr.setXmlDataType(STXmlDataType.STRING);
   xmlColumnPr.setXpath("/class/student/" + headers[i++]);
   xmlColumnPr.setMapId(xssfMap.getCtMap().getID());
  }

  XSSFRow row = sheet.createRow(0);
  int c = 0;
  for (String header : headers) {
   row.createCell(c++).setCellValue(header);
  }

  FileOutputStream out = new FileOutputStream(workbookFilePath);
  workbook.write(out);
  out.close();
  workbook.close();

 }


 //the XSSFRelation for /xl/xmlMaps.xml
 private final static class XSSFXmlMapsRelation extends POIXMLRelation {
  private XSSFXmlMapsRelation() {
   super(
    "application/xml",
    "http://schemas.openxmlformats.org/officeDocument/2006/relationships/xmlMaps",
    "/xl/xmlMaps.xml",
    MapInfo.class);
  }
 }
}