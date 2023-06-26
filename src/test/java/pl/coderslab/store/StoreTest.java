package pl.coderslab.store;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/Features", glue={"pl.coderslab.store"}, plugin = {"pretty","html:out"}, tags = "@edit")
//raport będzie w pliku out.html

public class StoreTest {

}
