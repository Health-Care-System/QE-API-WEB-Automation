package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.users.Doctor.DoctorChatbot;

public class DoctorChatbotSteps {

    @Steps
    DoctorChatbot chatbots;


    //    Scenario: Verify send POST request to chatbot endpoint with valid request (Cara Pembayaran Obat)
    @Given("I set chat bot API endpoint")
    public void setValidCustomerServiceEndpoint(){
        chatbots.setChatBotEndpoint();
    }

    @When("I send POST HTTP request for chatbot with the request is tips mengobati demam")
    public void successSendValidPostRequestCaraMengobatiDemam(){
        chatbots.sendPostRequestCaraMengobatiDemam();
    }

    @And("I receive valid message that successfully get data recommendation")
    public void receiveMessageSuccessGetDataRecommendation(){
        chatbots.validateMessageSuccessUsingChatbot();
    }

    //    Scenario: Verify send POST request to chatbot endpoint with empty request
    @When("I send POST HTTP request for chat bot with empty request")
    public void successSendPostChatbotWithEmptyRequest(){
        chatbots.sendPostChatBotWithEmptyRequest();
    }

    @And("I receive valid message that Failed on Request Validation")
    public void receiveMessageFailedRequestValidation(){
        chatbots.validateMessageChatbotEmptyRequest();
    }

    @Then("I receive HTTP response status code 400 Bad Request")
    public void validateStatus400BadRequest(){
        chatbots.receiveResponseStatusCode400BadRequest();
    }


    //    Scenario: Verify send POST request to chatbot endpoint with invalid request
    @When("I send POST HTTP request for chat bot with the request is asking for cara membuat nasi goreng")
    public void successSendPostChatbotInvalidRequest(){
        chatbots.sendPostChatbotInvalidRequest();
    }


    //    Scenario: Verify send PUT request to chatbot endpoint with valid request
    @When("I send PUT HTTP request for chat bot with the request is Health Advice")
    public void successSendPutToChatbot(){
        chatbots.sendPutToChatBotEndpoint();
    }

    @Then("I receive HTTP response status code 405 Method Not Allowed")
    public void validateStatus405(){
        chatbots.receiveResponseStatusCode405MethodNotAllowed();
    }


}

