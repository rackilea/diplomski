@Override
@Transactional
public void update(final ITemplate template) {
    super.update(new DBTemplate(template));
    templatesById.invalidate(template.getId());
    templatesByKey.invalidate(template.getKey());
}