Feature: Chatbots
  As a user
  I want to use chatbot
  So that I can get information about healthcare


  @Chatbots-042
  Scenario: Verify send POST request to chatbot endpoint with valid request (Tips mengobati demam)
    Given I set chat bot API endpoint
    When I send POST HTTP request for chatbot with the request is tips mengobati demam
    Then I receive HTTP response status code 200 OK
    And I receive valid message that successfully get data recommendation


  @Chatbots-043
  Scenario: Verify send POST request to chatbot endpoint with empty request
    Given I set chat bot API endpoint
    When I send POST HTTP request for chat bot with empty request
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that Failed on Request Validation

  @Chatbots-044
  Scenario: Verify send POST request to chatbot endpoint with invalid request
    Given I set chat bot API endpoint
    When I send POST HTTP request for chat bot with the request is asking for cara membuat nasi goreng
    Then I receive HTTP response status code 400 Bad Request


  @Chatbots-045
  Scenario: Verify send PUT request to chatbot endpoint with valid request
    Given I set chat bot API endpoint
    When I send PUT HTTP request for chat bot with the request is Health Advice
    Then I receive HTTP response status code 405 Method Not Allowed
