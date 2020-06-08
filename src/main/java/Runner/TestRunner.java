package Runner;

import org.junit.runner.RunWith;
import org.junit.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@SuppressWarnings("unused")
@RunWith(Cucumber.class)
@CucumberOptions(
	//	features="C:\\Users\\kajetanmellerowicz\\eclipse-workspace\\RestAssuredBDD\\src\\test\\java\\features\\GetPost.feature"
		features="src/test/java/features/GetPost.feature"
		,glue= {"steps"}  //package/folder for steps
		,plugin= {"pretty","html:test-output", "junit:junit_xml\\cucumber.xml", "json:json_output\\cucumber.json"}   //reporting formats e.g.: , "json:json_output\\cucumber.json"
		,monochrome= true  //display the console output: readable format				
		,strict=false  //if true: undefined steps fail entire execution
		,dryRun= false   // change to true to verify if all step = method mappings exists
		//,tags= {"@End2End , @SmokeTest\""}  //"tag1,tag2"="or","tag1" , "tag2"="and", ~tag=all but,  ; selected tag scenarios in feature file
		)

public class TestRunner {

}
