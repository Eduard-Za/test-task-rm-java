package data;

import org.testng.annotations.DataProvider;

import java.time.Instant;
import java.util.Arrays;

public class DataProviders {

    @DataProvider(name = "invalidCredentials",  parallel = true)
    public static Object[][] invalidCredentials() {
        return new Object[][]{
                {"", "", Arrays.asList("Email: The value can't be empty", "Password: The value can't be empty")},
                {"invalidEmail", "invalidPassword", Arrays.asList("Email: Wrong E-mail format",
                        "Password: The password must be between 6 and 15 characters (letters of the English alphabet) and contain at least one digit.")}
        };
    }

    @DataProvider(name = "validCredentials")
    public static Object[][] validCredentials() {
        return new Object[][]{
                {"eduardos1218@gmail.com", "71eE72z"}
        };
    }

    @DataProvider(name = "registrationData")
    public static Object[][] registrationData() {
        return new Object[][]{
                {Instant.now().getEpochSecond()
                        + "@email.com", "test", "lastName", "12345678"}
        };
    }
}
