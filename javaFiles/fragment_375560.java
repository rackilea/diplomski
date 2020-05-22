public static Map<Integer,String> extract(PEData exe) throws IOException {
    Map<Integer,String> importList = new HashMap<>();

    SectionLoader loader = new SectionLoader(exe);
    ImportSection idata = loader.loadImportSection();
    List<ImportDLL> imports = idata.getImports();
    for(ImportDLL dll : imports) {
        for(NameImport nameImport : dll.getNameImports()) {
            long iat = nameImport
                    .getDirEntryValue(DirectoryEntryKey.I_ADDR_TABLE_RVA);
            long ilt = nameImport
                    .getDirEntryValue(DirectoryEntryKey.I_LOOKUP_TABLE_RVA);
            long imageBase = exe.getOptionalHeader().get(
                    WindowsEntryKey.IMAGE_BASE);
            long addr = nameImport.getRVA() + imageBase;
            if(ilt != 0) addr = addr - ilt + iat;
            System.out.format("0x%X\t%s:%s%n", addr, dll.getName(), nameImport.getName());
            importList.put((int)addr, dll.getName() + ":" + nameImport.getName());
        }
    }

    return importList;
}