<?xml version="1.0"?>

<assembly
  xmlns="http://maven.apache.org/plugins/maven-assembly-plugin/assembly/1.1.2"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/plugins/maven-assembly-plugin/assembly/1.1.2 http://maven.apache.org/xsd/assembly-1.1.2.xsd"
>

  <id>${project.name}</id>

  <formats>
    <format>zip</format>
    <format>dir</format>
  </formats>

  <includeBaseDirectory>false</includeBaseDirectory>

  <dependencySet>
    <outputDirectory>lib</outputDirectory>
    <useProjectArtifact>true</useProjectArtifact>
    <includes>
      <include>${artifact.groupId}:${artifact.artifactId}</include>
    </includes>
  </dependencySet>

  <dependencySet>
    <outputDirectory>lib</outputDirectory>
    <useProjectArtifact>false</useProjectArtifact>
  </dependencySet>

</assembly>