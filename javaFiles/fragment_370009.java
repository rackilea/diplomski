package com.ggl.stopwatch.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class StopwatchModel {

    protected boolean isSplitTime;

    protected long startTime;

    protected long endTime;

    protected DefaultTableModel tableModel;

    protected List<Long> splitTimes;

    protected String[] columnNames = {"", "Increment", "Cumulative"};

    public StopwatchModel() {
        this.splitTimes = new ArrayList<Long>();
        this.isSplitTime = false;
        this.startTime = 0;
        this.endTime = 0;
        setTableModel();
    }

    public void resetTimes() {
        this.splitTimes.clear();
        this.isSplitTime = false;
        this.startTime = 0;
        this.endTime = 0;
    }

    public boolean isSplitTime() {
        return isSplitTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public long getLastSplitTime() {
        int size = splitTimes.size();
        if (size < 1) {
            return getStartTime();
        } else {
            return splitTimes.get(size - 1);
        }
    }

    public long getPenultimateSplitTime() {
        int size = splitTimes.size();
        if (size < 2) {
            return getStartTime();
        } else {
            return splitTimes.get(size - 2);
        }
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public int getTableModelRowCount() {
        return tableModel.getRowCount();
    }

    public void clearTableModel() {
        tableModel.setRowCount(0);
    }

    public int addTableModelRow(long startTime, long previousSplitTime, 
            long currentSplitTime, int splitCount) {
        String[] row = new String[3];

        row[0] = "Split " + ++splitCount;
        row[1] = formatTime(previousSplitTime, currentSplitTime, false);
        row[2] = formatTime(startTime, currentSplitTime, false);

        tableModel.addRow(row);

        return splitCount;
    }

    public void setStartTime() {
        if (getStartTime() == 0L) {
            this.startTime = System.currentTimeMillis();
        } else {
            long currentTime = System.currentTimeMillis();
            int size = splitTimes.size();
            if (size > 0) {
                long splitTime = splitTimes.get(size - 1);
                splitTime = splitTime - getEndTime() + currentTime;
                splitTimes.set(size - 1, splitTime);
            }
            this.startTime = currentTime - getEndTime() + getStartTime();
        }
    }

    protected void setTableModel() {
        this.tableModel = new DefaultTableModel();
        this.tableModel.addColumn(columnNames[0]);
        this.tableModel.addColumn(columnNames[1]);
        this.tableModel.addColumn(columnNames[2]);
    }

    public void setSplitTime() {
        this.splitTimes.add(System.currentTimeMillis());
        isSplitTime = true;
    }

    public void setEndTime() {
        Long split = System.currentTimeMillis();
        if (isSplitTime) {
            this.splitTimes.add(split);
        }
        this.endTime = split;
    }

    public String formatTime(long startTime, long time, boolean isTenths) {
        long elapsedTime = time - startTime;

        int seconds = (int) (elapsedTime / 1000L);

        int fraction = (int) (elapsedTime - ((long) seconds * 1000L));
        fraction = (fraction + 5) / 10;
        if (fraction > 99) {
            fraction = 0;
        }
        if (isTenths) {
            fraction = (fraction + 5) / 10;
            if (fraction > 9) {
                fraction = 0;
            }
        }


        int hours = seconds / 3600;
        seconds -= hours * 3600;

        int minutes = seconds / 60;
        seconds -= minutes * 60;

        StringBuilder builder = new StringBuilder();

        builder.append(hours);
        builder.append(":");
        if (minutes < 10) builder.append("0");
        builder.append(minutes);
        builder.append(":");
        if (seconds < 10) builder.append("0");
        builder.append(seconds);
        builder.append(".");
        if ((!isTenths) && (fraction < 10)) builder.append("0");
        builder.append(fraction);

        return builder.toString();
    }

}