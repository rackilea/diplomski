package com.tarun.lalwani

import org.spockframework.runtime.extension.AbstractGlobalExtension
import org.spockframework.runtime.model.FeatureInfo
import org.spockframework.runtime.model.SpecInfo
import spock.lang.Issue

import java.lang.annotation.Annotation

class IssueIncludeExtension extends AbstractGlobalExtension{
    @Override
    void visitSpec(SpecInfo spec) {
        def issuesList
        issuesList = System.properties["spock.issues"]

        if (issuesList) {
            def arrIssues = issuesList.split(",").toList()

            System.out.println('I was called')
            for (FeatureInfo feature : spec.getAllFeatures())
            {
                def method, ann;
                method = feature.getFeatureMethod();
                def issueAnnotation = method.getAnnotation(Issue.class);
                if (issueAnnotation) {
                    if (issueAnnotation.value().size() > 0)
                    {
                        if (issueAnnotation.value().toList().intersect(arrIssues))
                        {
                            //we have a matching issue
                            feature.setExcluded(false)
                        } else {
                            feature.setExcluded((true))
                        }


                    }
                } else {
                    // this doesn't belong to any issue
                    feature.setExcluded(true)
                }
            }

        } else {
            super.visitSpec(spec)
        }
    }


}