Feature: Manage Doctor by Admin
  As a user
  I want to login
  So that i can start consultation

  @RegisterDoctor-163
  Scenario: Verify send POST request to register doctor endpoint with valid body
    Given I set Register Doctor API endpoint
    When I send POST HTTP request for register doctor with valid request body
    Then I receive HTTP response status code 201 OK
    And I receive valid message that Register Successful

  @RegisterDoctor-166
  Scenario: Verify send POST request to register doctor endpoint with invalid email format (without "@")
    Given I set Register Doctor API endpoint
    When I send POST HTTP request for register doctor with invalid email format
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that Failed email validation

  @RegisterDoctor-168
  Scenario: Verify send POST request to register doctor endpoint with password is less than 8 character
    Given I set Register Doctor API endpoint
    When I send POST HTTP request for register doctor with password less than 8 character
    Then I receive HTTP response status code 400 Bad Request
    And I receive valid message that Failed passport min Validation

  @GetAllDoctor-173
  Scenario: Verify send GET request to get all doctors endpoint
    Given I set Get all Doctor API endpoint
    When I send GET HTTP request for all doctor endpoint
    Then I receive HTTP response status code 200 OK
    And I receive valid message that successfully get data doctor

  @GetAllDoctor-174
  Scenario: Verify send POST request to get all doctors endpoint
    Given I set Get all Doctor API endpoint
    When I send POST HTTP request for all doctor endpoint
    Then I receive HTTP response status code 405 Method Not Allowed
