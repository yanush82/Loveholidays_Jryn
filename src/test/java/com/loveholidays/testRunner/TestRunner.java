package com.loveholidays.testRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features"
        ,glue={"com.loveholidays.stepdef"}
        ,plugin = { "pretty" }
        ,monochrome = true
        ,tags = //"@SearchResults"
         "@Banner"
)
public class TestRunner {


}
