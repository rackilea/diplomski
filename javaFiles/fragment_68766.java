@Transactional
    public void add(ParentDTO parentDTO) {
//your child object should have all the property set here so that all values will be automatically inserted.
parentDTO.setChild(child);
child.setParent(parentDTO);
Parent parent = mapper.map(parentDTO, Parent.class);
parentRepository.save(parent);
//Even you can set property here