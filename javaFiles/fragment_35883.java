dtos.parallelStream().forEach(dto -> {
            try {
                processDTO(dealerCode, yearPeriod, monthPeriod, dto);
            } catch (FileAlreadyExistsInS3Exception e) {
                failedToUploadDTOs.add(e.getLocalizedMessage() + ": " + dto.fileName() + ".json");
            }
        });