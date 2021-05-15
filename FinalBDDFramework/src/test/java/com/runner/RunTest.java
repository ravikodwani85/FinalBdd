package com.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/parallel", glue="parallel", dryRun=false, monochrome=true, strict=false, plugin= {"pretty", "html:target/cucumber/report.json"})

public class RunTest {
	
	
	

}
