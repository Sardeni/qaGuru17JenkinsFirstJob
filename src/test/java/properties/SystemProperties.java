package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemProperties {


    @Test
    @Tag("one_property")
    void TestProperties() {

        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName);
    }
}
