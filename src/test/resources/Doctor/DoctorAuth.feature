Feature: Login Doctor
  As a user
  I want to login
  So that i can start consultation

  @Login-100
  Scenario: Verify send POST request to login doctor endpoint with valid email and password
    Given I set login doctor API endpoint
    When I send POST HTTP request for login doctor with valid request body
    Then I receive HTTP response status code 200 OK
    And I receive valid message that Login Successful

  @Login-101
  Scenario: Verify send POST request to login doctor endpoint with invalid email and valid password
    Given I set login doctor API endpoint
    When I send POST HTTP request for login doctor with invalid email and valid password
    Then I receive HTTP response status code 401 Unauthorized
    And I receive valid message that email not register

  @Login-102
  Scenario: Verify send POST request to login doctor endpoint with valid email and invalid password
    Given I set login doctor API endpoint
    When I send POST HTTP request for login doctor with valid email and invalid password
    Then I receive HTTP response status code 401 Unauthorized
    And I receive valid message that incorrect password
