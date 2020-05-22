package com.example.server.servlet;

import com.google.appengine.tools.appstats.AppstatsFilter;

import java.io.IOException;
import java.util.Random;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AppstatsImprovedFilter extends AppstatsFilter {

    private double recordFraction;
    private Random random;

    @Override
    public synchronized void init(FilterConfig config) {
        super.init(config);
        String recordFractionConfig = config.getInitParameter("recordFraction");
        recordFraction = recordFractionConfig == null ? 1.0 : Double.parseDouble(recordFractionConfig);
        random = new Random();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filters)
            throws IOException, ServletException {
        if (recordFraction < 1.0 && random.nextDouble() > recordFraction) {
            filters.doFilter(request, response);
        } else {
            super.doFilter(request, response, filters);
        }
    }
}