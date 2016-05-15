/**
 * <copyright>
 * 
 * Copyright (c) 2015 PlugBee. All rights reserved.
 * 
 * This program and the accompanying materials are made available 
 * under the terms of the Eclipse Public License v1.0 which 
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Amine Lajmi - Initial API and implementation
 * 
 * </copyright>
 */
package org.dslforge.xtext.generator.web.build

import org.dslforge.common.AbstractGenerator
import org.dslforge.common.IWebProjectFactory
import org.dslforge.xtext.generator.XtextGrammar
import org.eclipse.core.runtime.IProgressMonitor

class GenProductPomXml extends AbstractGenerator {

	var XtextGrammar grammar

	new() {
		basePath = ""
	}

	override doGenerate(IWebProjectFactory factory, IProgressMonitor monitor) {
		grammar = factory.input as XtextGrammar
		projectName = factory.project.name
		grammarShortName = grammar.getShortName()
		relativePath = "/" + grammarShortName.toLowerCase + "/"
		factory.generateFile(relativePath, "pom.xml", toXml(), monitor)
	}

	def toXml() '''
<?xml version="1.0" encoding="UTF-8"?>
<project
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"
    xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">

  <modelVersion>4.0.0</modelVersion>

  <parent>
    <groupId>dslforge.example</groupId>
    <artifactId>�projectName�.parent.parent</artifactId>
    <relativePath>../parent/parent</relativePath>
    <version>1.0.0-SNAPSHOT</version>
  </parent>

  <artifactId>�projectName.replace(".build", ".product")�</artifactId>
  <packaging>eclipse-repository</packaging>

  <properties>
    <war-filename>�grammarShortName.toLowerCase�</war-filename>
  </properties>

  <build>
    <plugins>
      <!-- Configure the p2 director -->
      <plugin>
        <groupId>org.eclipse.tycho</groupId>
        <artifactId>tycho-p2-director-plugin</artifactId>
        <version>${tycho.version}</version>
        <executions>
          <execution>
            <id>materialize-products</id>
            <goals>
              <goal>materialize-products</goal>
            </goals>
          </execution>
          <execution>
            <id>archive-products</id>
            <goals>
              <goal>archive-products</goal>
            </goals>
          </execution>
        </executions>
      </plugin>

      <!-- Remove javax.servlet from the bundles.info -->
      <plugin>
        <groupId>com.google.code.maven-replacer-plugin</groupId>
        <artifactId>maven-replacer-plugin</artifactId>
        <version>${replacer-version}</version>
        <executions>
          <execution>
            <phase>verify</phase>
            <goals>
              <goal>replace</goal>
            </goals>
          </execution>
        </executions>
        <configuration>
          <file>target/products/${project.artifactId}/win32/win32/x86_64/configuration/config.ini</file>
          <replacements>
            <replacement>
              <token>osgi.bundles=</token>
              <value>osgi.bundles=org.eclipse.equinox.servletbridge.extensionbundle,</value>
            </replacement>
            <replacement>
              <token>reference\\:file\\:javax.servlet.*?jar@4,</token>
              <value></value>
            </replacement>
          </replacements>
          <regexFlags>
            <regexFlag>CASE_INSENSITIVE</regexFlag>
            <regexFlag>UNIX_LINES</regexFlag>
          </regexFlags>
        </configuration>
      </plugin>

      <!-- Configure the assembly plugin to zip the war file -->
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-assembly-plugin</artifactId>
        <version>${assembly-version}</version>
        <configuration>
          <descriptors>
            <descriptor>assembly.xml</descriptor>
          </descriptors>
          <!-- Configure the war's filename -->
          <finalName>${war-filename}</finalName>
          <appendAssemblyId>false</appendAssemblyId>
        </configuration>
        <executions>
          <execution>
            <id>make-assembly</id>
            <phase>verify</phase>
            <goals>
              <goal>single</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
 
    </plugins>
  </build>

</project>
	'''
}