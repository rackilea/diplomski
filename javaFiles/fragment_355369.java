private Session getSessionFromStore(String sessionId){
        DataGridSession s = (DataGridSession)cacheManager.getCache("sessions").get(sessionId);
        if(s!=null){
            try {
                Field notesField;
                notesField = StandardSession.class.getDeclaredField("notes");
                notesField.setAccessible(true);
                notesField.set(s, new HashMap<String, Object>());
                s.setManager(this);
            } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
                throw new RuntimeException(e);
            }
        }
        return s;
    }