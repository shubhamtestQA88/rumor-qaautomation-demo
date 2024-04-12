package com.agroworlds.login.tests;

import java.util.ArrayList;

import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.utility.ScreenRecorderUtil;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.List;

public class TestNGProgrammaticRun {

    public static void main(String[] args) throws Exception {
    	
    	ScreenRecorderUtil.startRecord("main");
      
        TestNG testNG = new TestNG();
      
        List<XmlSuite> suites = new ArrayList<>();

        XmlSuite suite1 = new XmlSuite();
        suite1.setName("Suite1");
        String relativePath = "./Testng.xml"; 
        suite1.setSuiteFiles(List.of(relativePath));

        suites.add(suite1);
     
        testNG.setXmlSuites(suites);

        testNG.run();
        
        ScreenRecorderUtil.stopRecord();
    }
}
