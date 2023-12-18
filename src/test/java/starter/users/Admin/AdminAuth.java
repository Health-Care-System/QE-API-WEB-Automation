package starter.users.Admin;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class AdminAuth {
    protected String url = "https://www.dev.healthify.my.id";

//    private int emailCounter = 515;

    private static String adminToken;

    //    Scenario: Verify send POST request to login admin endpoint with valid email and password
    @Step("I set login admin API endpoint")
    public String setLoginAdminEndpoint() {
        return url + "/admins/login";
    }

    @Step("I send POST HTTP request for login with valid request body")
    public void sendPostLoginValid() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", "adminsuperr@mail.com");
        requestBody.put("password", "tM@4D>H$Vaqn4I2");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setLoginAdminEndpoint());

        Response response = SerenityRest.lastResponse();
        adminToken = response.path("results.token");
    }

    @Step("I receive HTTP response status code 200 OK")
    public void receiveResponseStatusCode200OK() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I receive valid message that Login Successful")
    public void validateMessageValidLogin() {
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("login successful")));
    }


    //    Scenario: Verify send POST request to login admin endpoint with invalid email and valid password
    @Step("I send POST HTTP request for login with invalid email and valid password")
    public void sendPostLoginInvalidEmail() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", "adminsuper@mail.com");
        requestBody.put("password", "tM@4D>H$Vaqn4I2");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setLoginAdminEndpoint());
    }

    @Step("I receive HTTP response status code 401 Unauthorized")
    public void receiveResponseStatusCode401Unauthorized() {
        restAssuredThat(response -> response.statusCode(401));
    }

    @Step("I receive valid message that Failed Validation")
    public void validateMessageLoginFailed() {
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("invalid email or password")));
    }


    //    Verify send POST request to login admin endpoint with valid email and invalid password
    @Step("I send POST HTTP request for login with valid email and invalid password")
    public void sendPostLoginInvalidPassword() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", "adminsuperr@mail.com");
        requestBody.put("password", "tM@4D>H$Vaqn4I");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setLoginAdminEndpoint());
    }

}