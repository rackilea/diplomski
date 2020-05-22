try {
        return contactService.update(contact);
    } catch (Exception e) {
        e.printStackTrace();
        return CryptoUtils.generateFailureResponseEntity(ErrorCode.CODE_SQL_EXCEPTION, e.getMessage());
    }