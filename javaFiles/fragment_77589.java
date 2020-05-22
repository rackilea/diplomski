public Integer saveTask(TaskDTO taskDTO) {
        Integer identifier = null;
        try {
            ....
            ....
            Session session = sessionFactory.getCurrentSession();
            for(int i=0 ; i < taskDTO.getTags().size(); i++) {
                TagDTO tagDTO = taskDTO.getTags().get(i);
                TagDTO data = (TagDTO) session.createCriteria(TagDTO.class).add(Restrictions.eq("tagName", tagDTO.getTagName())).uniqueResult();
                if(null == data) {
                    taskDTO.getTags().set(i,tagDTO);
                } else {
                    taskDTO.getTags().set(i,data);
                }

            }
            session.beginTransaction(); // <-- this is key point, started transaction from here.
            for(int i = 0 ; i < taskDTO.getUsers().size() ; i++) {
                UserDTO userDTO = taskDTO.getUsers().get(i);
                userDTO = (UserDTO) session.get(UserDTO.class,userDTO.getUserId());
                userDTO.getTasks().add(taskDTO);
                taskDTO.getUsers().set(i,userDTO);
            }
            ....
            ....
            identifier = (Integer) session.save(taskDTO);
            return identifier;
        } catch (Exception ex) {
            logger.error("unable to save task ", ex);
        }
        return null;
    }