package automation.api.test;

import automation.api.domain.User;
import org.apache.http.HttpStatus;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest extends BaseTest {
    private static final String LOGIN_USER = "/login";

    @Test
    public void testUnableToLoginWhenPasswordMissing() {
        User user = new User();
        user.setEmail("peter@klaven");

        given().
            body(user).
        when().
            post(LOGIN_USER).
        then().
            statusCode(HttpStatus.SC_BAD_REQUEST).
            body("error", is("Missing password"));
    }

    @Test
    public void testAbleLogin() {
        String expectedToken = getExpectedItemsPerPage();

        Map<String, String> user = new HashMap<>();
        user.put("email", "eve.holt@reqres.in");
        user.put("password", "cityslicka");

        given().
            body(user).
        when().
            post(LOGIN_USER).
        then().
            statusCode(HttpStatus.SC_OK);

        assertThat(expectedToken, is(notNullValue()));
    }

    private String getExpectedItemsPerPage() {
        Map<String, String> user = new HashMap<>();
        user.put("email", "eve.holt@reqres.in");
        user.put("password", "cityslicka");

        return given().
                    body(user).
                when().
                    post(LOGIN_USER).
                then().
                    statusCode(HttpStatus.SC_OK).
                extract().
                    path("token");
    }
}
