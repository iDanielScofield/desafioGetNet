package automation.api.test;

import automation.api.domain.User;
import org.apache.http.HttpStatus;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class RegisterTest extends BaseTest {
    private static final String REGISTER_NEW_USER = "/register";

    @Test
    public void testUnableToRegisterWhenPasswordMissing() {
        User user = new User();
        user.setEmail("sydney@fife");

        given().
            body(user).
        when().
            post(REGISTER_NEW_USER).
        then().
            statusCode(HttpStatus.SC_BAD_REQUEST).
            body("error", is("Missing password"));
    }

    @Test
    public void testAbleCreateRegister() {
        Map<String, String> user = new HashMap<>();
        user.put("email", "eve.holt@reqres.in");
        user.put("password", "pistol");

        given().
            body(user).
        when().
            post(REGISTER_NEW_USER).
        then().
            statusCode(HttpStatus.SC_OK);
    }
}
