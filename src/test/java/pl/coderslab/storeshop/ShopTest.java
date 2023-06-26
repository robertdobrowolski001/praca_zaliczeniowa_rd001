package pl.coderslab.storeshop;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/Features", glue={"pl.coderslab.storeshop"}, plugin = {"pretty","html:out"}, tags = "@shopping")
//raport będzie w pliku out.html

public class ShopTest {
}
