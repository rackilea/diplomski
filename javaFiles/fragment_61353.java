FacesContext facesContext = FacesContext.getCurrentInstance();
ExternalContext externalContext = facesContext.getExternalContext();
externalContext.setResponseContentType("application/vnd.ms-excel");
externalContext.setResponseHeader("Content-Disposition", "attachment; filename=" + pkgLine.getShortname() + ".xls");
writeExcelSheet(viewLines, externalContext.getResponseOutputStream());
facesContext.responseComplete();