SharedAccessAccountPolicy accountPolicy = new SharedAccessAccountPolicy();
accountPolicy.setPermissions(EnumSet.allOf(SharedAccessAccountPermissions.class));
accountPolicy.setSharedAccessStartTime(Date.valueOf(LocalDate.now().minusYears(2)));
accountPolicy.setSharedAccessExpiryTime(Date.valueOf(LocalDate.now().plusYears(2)));

String sas = csa.generateSharedAccessSignature(accountPolicy);