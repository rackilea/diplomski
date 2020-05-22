/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.apache.ant.dotnet.build;

import java.io.File;
import java.util.List;

import org.apache.ant.dotnet.util.CollectionUtils;

import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Runs a MSBuild build process.
 */
public class MSBuildTask extends AbstractBuildTask {

    private static final String TARGET = "generated-by-ant";
    private static final String ROOT = "Project";
    private static final String MSBUILD_NS =
    "http://schemas.microsoft.com/developer/msbuild/2003";

    public MSBuildTask() {
        super();
    }

    protected String getExecutable() {
        return "MSBuild.exe";
    }

    protected String[] getBuildfileArguments(File buildFile) {
        if (buildFile != null) {
            return new String[] {
                buildFile.getAbsolutePath()
            };
        } else {
            return new String[0];
        }
    }

    protected String[] getTargetArguments(List targets) {
        if (targets.size() > 0) {
            StringBuffer sb = new StringBuffer("/target:");
            sb.append(CollectionUtils.flattenToString(targets, ";"));
            return new String[]{sb.toString()};
        } else {
            return new String[0];
        }
    }

    protected String[] getPropertyArguments(List properties) {
        if (properties.size() > 0) {
            StringBuffer sb = new StringBuffer("/property:");
            sb.append(CollectionUtils.flattenToString(properties, ";"));
            return new String[]{sb.toString()};
        } else {
            return new String[0];
        }
    }

    /**
     * Turn the DocumentFragment into a DOM tree suitable as a build
     * file when serialized.
     *
     * <p>If we have exactly one <Project> child, return that.
     * Otherwise if we have only <Task> children, wrap them into a
     * <Target> which in turn gets wrapped into a <Project>.
     * Otherwise, fail.</p>
     */
    protected Element makeTree(DocumentFragment f) {
        NodeList nl = f.getChildNodes();
        if (nl.getLength() == 1 
            && nl.item(0).getNodeType() == Node.ELEMENT_NODE
            && nl.item(0).getNodeName().equals(ROOT)) {
            return (Element) nl.item(0);
        } else {
            Element p = f.getOwnerDocument().createElementNS(MSBUILD_NS,
                                 ROOT);
            p.setAttribute("DefaultTargets", TARGET);

            Element t = f.getOwnerDocument().createElementNS(MSBUILD_NS,
                                 "Target");
            t.setAttribute("Name", TARGET);

            p.appendChild(t);
            t.appendChild(f);
            return p;
        }
    }
}