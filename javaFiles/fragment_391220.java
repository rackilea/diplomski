package com.maddonkeysoftware.donkeydesktopmonitor;

import java.util.LinkedList;
import java.util.Queue;

import com.maddonkeysoftware.donkeydesktopmonitor.requests.UrlWrapper;

public class MockBeanProvider {

    private static Queue<UrlWrapper> urlWrapperQueue = new LinkedList<UrlWrapper>();

    private MockBeanProvider() {}

    public static void enqueueMockUrl(UrlWrapper mock){
        urlWrapperQueue.add(mock);
    }

    public Object fetchMockUrl(String args) {
        return urlWrapperQueue.poll();
    }
}