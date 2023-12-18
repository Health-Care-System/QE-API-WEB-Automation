package starter.users.Doctor;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class DoctorAuth {
        protected String url = "https://www.dev.healthify.my.id";

        private static String doctorToken;

        //    Scenario: Verify send POST request to login doctor endpoint with valid email and password
        @Step("I set login doctor API endpoint")
        public String setLoginDoctorEndpoint() {
            return url + "/doctors/login";
        }

        @Step("I send POST HTTP request for login with valid request body")
        public void sendPostLoginValidDoctor() {
            JSONObject requestBody = new JSONObject();

            requestBody.put("email", "fdlhazizah25@mail.com");
            requestBody.put("password", "a123456789");

            SerenityRest.given()
                    .header("Content-Type", "application/json")
                    .body(requestBody.toString())
                    .post(setLoginDoctorEndpoint());

            Response response = SerenityRest.lastResponse();
            doctorToken = response.path("results.token");
        }


        //    Scenario: Verify send POST request to login doctor endpoint with invalid email and valid password
        @Step("I send POST HTTP request for login with invalid email and valid password")
        public void sendPostLoginInvalidEmail() {
            JSONObject requestBody = new JSONObject();

            requestBody.put("email", "fdlhazizah@mail.com");
            requestBody.put("password", "a123456789");

            SerenityRest.given()
                    .header("Content-Type", "application/json")
                    .body(requestBody.toString())
                    .post(setLoginDoctorEndpoint());
        }

        @Step("I receive valid message that email not register")
        public void validateMessageEmailNotRegister() {
            restAssuredThat(response -> response.body("'meta'.'message'", equalTo("email not registered")));
        }


        //    Verify send POST request to login doctor endpoint with valid email and invalid password
        @Step("I send POST HTTP request for login doctor with valid email and invalid password")
        public void sendPostLoginInvalidPassword() {
            JSONObject requestBody = new JSONObject();

            requestBody.put("email", "fdlhazizah25@mail.com");
            requestBody.put("password", "password123");

            SerenityRest.given()
                    .header("Content-Type", "application/json")
                    .body(requestBody.toString())
                    .post(setLoginDoctorEndpoint());
        }

        @Step("I receive valid message that incorrect password")
        public void validateMessageInvalidPassword() {
            restAssuredThat(response -> response.body("'meta'.'message'", equalTo("incorrect password")));
    }
}
