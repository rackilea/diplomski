when:

        mock.use {
          folderValidator.validate(new File("."))
        }

then:
        folderValidator.listMissingFiles.size == 3