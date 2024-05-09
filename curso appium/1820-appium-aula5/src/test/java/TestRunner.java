import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "C:\\Users\\LowCost\\Desktop\\curso appium\\1820-appium-aula5\\src\\test\\resources",
            glue = {"com.alura"}
    )

    public class TestRunner {

    }
