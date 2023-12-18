package starter.users.Doctor;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class DoctorChatbot {

    protected String url = "https://www.healthify.my.id";


    //    Scenario: Verify send POST request to chatbot endpoint with valid request (Tips mengobati demam)
    @Step("I set chat bot API endpoint")
    public String setChatBotEndpoint(){
        return  url + "/chatbot";
    }

    @Step("I send POST HTTP request for chatbot with the request is tips mengobati demam")
    public void sendPostRequestCaraMengobatiDemam(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("request", "cara mengobati demam");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setChatBotEndpoint());
    }

    @Step("I receive valid message that successfully get data recommendation")
    public void validateMessageSuccessUsingChatbot(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("successfully get data recommendation")));
    }


    //    Scenario: Verify send POST request to chatbot endpoint with empty request
    @Step("I send POST HTTP request for chat bot with empty request")
    public void sendPostChatBotWithEmptyRequest(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("request", "");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setChatBotEndpoint());
    }

    @Step("I receive valid message that Failed on Request Validation")
    public void validateMessageChatbotEmptyRequest(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("Field 'Request' failed on 'required' validation")));
    }

    @Step("Then I receive HTTP response status code 400 Bad Request")
    public void receiveResponseStatusCode400BadRequest(){
        restAssuredThat(response -> response.statusCode(400));
    }

    //    Scenario: Verify send POST request to chatbot endpoint with invalid request
    @Step("I send POST HTTP request for chat bot with the request is asking for cara membuat nasi goreng")
    public void sendPostChatbotInvalidRequest(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("request", "cara membuat nasi goreng");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setChatBotEndpoint());
    }


    //    Scenario: Verify send PUT request to chatbot endpoint with valid request
    @Step("I send PUT HTTP request for chat bot with the request is Health Advice")
    public void sendPutToChatBotEndpoint(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("request", "tips mengobati demam");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .put(setChatBotEndpoint());
    }

    @Step("I receive HTTP response status code 405 Method Not Allowed")
    public void receiveResponseStatusCode405MethodNotAllowed(){
        restAssuredThat(response -> response.statusCode(405));
    }

}
