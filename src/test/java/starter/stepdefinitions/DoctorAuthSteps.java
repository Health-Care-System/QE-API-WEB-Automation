package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.users.Doctor.DoctorAuth;


public class DoctorAuthSteps {
    @Steps
    DoctorAuth auth;
    //    Scenario: Verify send POST request to login admin endpoint with valid email, and password
    @Given("I set login doctor API endpoint")
    public void setValidLoginDoctorEndpoint(){
        auth.setLoginDoctorEndpoint();
    }
    @When("I send POST HTTP request for login doctor with valid request body")
    public void successSendPostLoginValidDoctor(){
        auth.sendPostLoginValidDoctor();
    }

    //    Scenario: Verify send POST request to login user endpoint with invalid email and valid password
    @When("I send POST HTTP request for login doctor with invalid email and valid password")
    public void successSendPostLoginUnregisteredEmail(){
        auth.sendPostLoginInvalidEmail();
    }

    @And("I receive valid message that email not register")
    public void receiveMessageUnregisterEmail(){
        auth.validateMessageEmailNotRegister();
    }

    //    Scenario: Verify send POST request to login user endpoint with valid email and invalid password
    @When("I send POST HTTP request for login doctor with valid email and invalid password")
    public void successSendPostLoginInvalidPassword(){
        auth.sendPostLoginInvalidPassword();
    }

    @And("I receive valid message that incorrect password")
    public void receiveMessageInvalidPassword(){
        auth.validateMessageInvalidPassword();
    }
}

