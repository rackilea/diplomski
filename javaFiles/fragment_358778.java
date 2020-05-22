public class FlashTableRowFactory<T> implements Callback<TableView<T>, TableRow<T>> {

    private final static PseudoClass FLASH_HIGHLIGHT = PseudoClass.getPseudoClass("flash-highlight");

    public FlashTableRowFactory(TableView<T> tableView) {
        tableView.getItems().addListener((ListChangeListener.Change<? extends T> c) -> {
            while (c.next()) {
                if (c.wasPermutated()) {
                    int from = c.getFrom();
                    int to = c.getTo();
                    permutationUpdate(scheduledTasks, c, from, to);
                    permutationUpdate(unscheduledTasks, c, from, to);
                }
                if (c.wasReplaced()) {
                    addRange(c.getFrom(), c.getTo());
                } else if (c.wasRemoved()) {
                    int from = c.getFrom();
                    int removed = c.getRemovedSize();
                    removeRange(scheduledTasks, from, from + removed);
                    removeRange(unscheduledTasks, from, from + removed);
                    modifyIndices(unscheduledTasks, from, -removed);
                    modifyIndices(scheduledTasks, from, -removed);
                } else if (c.wasAdded()) {
                    int from = c.getFrom();
                    int to = c.getTo();
                    modifyIndices(unscheduledTasks, from, to - from);
                    modifyIndices(scheduledTasks, from, to - from);
                    addRange(from, to);
                }
            }

            // remove all flashTasks that are older than the youngest for a
            // given index
            Set<Integer> indices = new HashSet<>();
            removeDuplicates(unscheduledTasks, indices);
            removeDuplicates(scheduledTasks, indices);

            flashingIndices.clear();
            updateFlash(lastUpdate);
            refreshFlash();
            if (!unscheduledTasks.isEmpty()) {
                flasher.start();
            }
        });
        this.tableView = tableView;
    }

    private static void removeDuplicates(List<FlashTask> list, Set<Integer> found) {
        for (Iterator<FlashTask> iterator = list.iterator(); iterator.hasNext();) {
            FlashTask next = iterator.next();
            if (!found.add(next.index)) {
                iterator.remove();
            }
        }
    }

    private static void modifyIndices(List<FlashTask> list, int minModify, int by) {
        for (FlashTask task : list) {
            if (task.index >= minModify) {
                task.index += by;
            }
        }
    }

    private void addRange(int index, int to) {
        for (; index < to; index++) {
            unscheduledTasks.add(new FlashTask(index));
        }
    }

    private static void removeRange(List<FlashTask> list, int from, int to) {
        for (Iterator<FlashTask> iterator = list.iterator(); iterator.hasNext();) {
            FlashTask next = iterator.next();
            if (next.index >= from && next.index < to) {
                iterator.remove();
            }
        }
    }

    private static void permutationUpdate(List<FlashTask> list, ListChangeListener.Change<?> c, int from, int to) {
        for (FlashTask task : list) {
            if (task.index < to && task.index >= from) {
                task.index = c.getPermutation(task.index);
            }
        }
    }

    // set of item indices that should flash
    private final Set<Integer> flashingIndices = new HashSet<>();

    // references to every row created by this factory
    private final List<SoftReference<TableRow<T>>> rows = new LinkedList<>();

    // tasks waiting to be scheduled
    private final List<FlashTask> unscheduledTasks = new LinkedList<>();

    // tasks currently being animated
    private final List<FlashTask> scheduledTasks = new LinkedList<>();

    private static class FlashTask {

        int index;
        long schedulingTime;

        public FlashTask(int index) {
            this.index = index;
        }

    }

    private final TableView<T> tableView;
    private long lastUpdate;

    /**
     * Updates flashingIndices set
     * @param now the current timestamp
     * @return true if the set has been modified, otherwise false.
     */
    private boolean updateFlash(long now) {
        boolean modified = false;
        for (Iterator<FlashTask> iterator = scheduledTasks.iterator(); iterator.hasNext();) {
            FlashTask next = iterator.next();

            // running time in seconds
            double runningTime = (now - next.schedulingTime) / (1000d * 1000d * 1000d);

            // slows down the animation for demonstration
            final double animationSpeed = 0.1;

            if (runningTime < 0.4 / animationSpeed) {
                // no need to handle tasks that run for less than 0.4 seconds
                break;
            } else if (runningTime > 1.6 / animationSpeed) {
                // end of task reached
                iterator.remove();
                modified |= flashingIndices.remove(next.index);
            } else if (runningTime > 0.8 / animationSpeed && runningTime < 1.2 / animationSpeed) {
                // second "inactive" interval during animation
                modified |= flashingIndices.remove(next.index);
            } else {
                // activate otherwise
                modified |= flashingIndices.add(next.index);
            }
        }
        return modified;
    }

    private final AnimationTimer flasher = new AnimationTimer() {

        @Override
        public void handle(long now) {
            lastUpdate = now;

            // activate waiting flash tasks
            for (FlashTask task : unscheduledTasks) {
                task.schedulingTime = now;
            }
            scheduledTasks.addAll(unscheduledTasks);
            unscheduledTasks.clear();

            if (updateFlash(now)) {
                refreshFlash();
                if (scheduledTasks.isEmpty()) {
                    // stop, if there are no more tasks
                    stop();
                }
            }
        }

    };

    /**
     * Sets the pseudoclasses of rows based on flashingIndices set
     */
    private void refreshFlash() {
        for (Iterator<SoftReference<TableRow<T>>> iterator = rows.iterator(); iterator.hasNext();) {
            SoftReference<TableRow<T>> next = iterator.next();
            TableRow<T> row = next.get();
            if (row == null) {
                // remove references claimed by garbage collection
                iterator.remove();
            } else {
                row.pseudoClassStateChanged(FLASH_HIGHLIGHT, flashingIndices.contains(row.getIndex()));
            }
        }
    }

    @Override
    public TableRow<T> call(TableView<T> param) {
        if (tableView != param) {
            throw new IllegalArgumentException("This factory can only be used with the table passed to the constructor");
        }
        return new FlashRow();
    }

    private class FlashRow extends TableRow<T> {

        {
            rows.add(new SoftReference<>(this));
        }

        @Override
        public void updateIndex(int i) {
            super.updateIndex(i);

            // update pseudoclass based on flashingIndices set
            pseudoClassStateChanged(FLASH_HIGHLIGHT, flashingIndices.contains(i));
        }

    }

}