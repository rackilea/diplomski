files.addAll(Arrays.asList(folder.listFiles(new FileFilter(){

        @Override
        public boolean accept(File f) {
            return f.getName().endsWith(CustomConstantsRepository.FILE_EXT_DAT) && f.getName().startsWith(fileName)));
        }

})));