package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.users.Admin.AdminAuth;

public class AdminAuthSteps {
    @Steps
    AdminAuth auth;
    //    Scenario: Verify send POST request to login admin endpoint with valid email, and password
    @Given("I set login admin API endpoint")
    public void setValidLoginAdminEndpoint(){
        auth.setLoginAdminEndpoint();
    }
    @When("I send POST HTTP request for login with valid request body")
    public void successSendPostLoginValid(){
        auth.sendPostLoginValid();
    }

    @And("I receive valid message that Login Successful")
    public void receiveMessageLoginSuccessful(){
        auth.validateMessageValidLogin();
    }

    @Then("I receive HTTP response status code 200 OK")
    public void validateStatus200OK(){
        auth.receiveResponseStatusCode200OK();
    }

    //    Scenario: Verify send POST request to login user endpoint with invalid email and valid password
    @When("I send POST HTTP request for login with invalid email and valid password")
    public void successSendPostLoginInvalidEmail(){
        auth.sendPostLoginInvalidEmail();
    }

    @Then("I receive HTTP response status code 401 Unauthorized")
    public void validateStatus401Unauthorized(){
        auth.receiveResponseStatusCode401Unauthorized();
    }

    @And("I receive valid message that Failed Validation")
    public void receiveMessageLoginFailed(){
        auth.validateMessageLoginFailed();
    }


    //    Scenario: Verify send POST request to login user endpoint with valid email and invalid password
    @When("I send POST HTTP request for login with valid email and invalid password")
    public void successSendPostLoginInvalidPassword(){
        auth.sendPostLoginInvalidPassword();
    }

}

