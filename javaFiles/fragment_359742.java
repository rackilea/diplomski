import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
...
  run.setBold(true);
  CTOnOff ctonoff = CTOnOff.Factory.newInstance();
  ctonoff.setVal(STOnOff.ON);
  run.getCTR().getRPr().setBCs(ctonoff);
...