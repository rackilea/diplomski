Date d;
CriteriaQuery<Task> cq = cb.createQuery(Task.class);
...
TypedQuery<Task> tq = em.createQuery(cq);
List<Task> tasks = tq.getResultList();
for (Task task : tasks) {
    task.setDone(d);
    em.merge(task);
}
// or
Task task = tq.getSingleResult();
task.setDone(d);
em.merge(task);