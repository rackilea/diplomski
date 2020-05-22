URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8064/spacestudy/" +instituteIdentifier +"/communication/alertmanagement/getDepartmentInstitute")
              .queryParam("nUserId", nUserId)
              .queryParam("nDeptInst", nInstId)
              .build().toUri();

Integer nInstTo = restTemplate.getForObject(uri,Integer.class);