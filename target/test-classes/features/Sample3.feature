@regression
Feature: Introduction to cucumber part 3
  As a test engineer
  I want to be able to write and execute a scenario outline

  @debug
  Scenario Outline: a new scenario outline
    Given I am on age page
    When I enter name: "<name>"
    And I enter age: <age>
    And I click submit age
    Then I see message: "<message>"
  @working
    Examples:
      | name | age | message                      |
      | Ann  | 5   | Hello, Ann, you are a kid    |
      | Bob  | 61  | Hello, Bob, you are an adult |
  @not_working
    Examples:
      | name | age | message                      |
      | Tom  | 15  | Hello, Tom, you are a kid    |

  Scenario: Enter a number 1
    Given I am on task page
    When I enter number: 335
    Then I should see an error: "Number is too big"

  @part3
  Scenario Outline: Enter a number
    Given I am on task page
    When I enter number: <number>
    Then I should see an error: <error message>
  Examples:
    | number | error message         |
    | 35     | "Number is too small" |
    | 335    | "Number is too big"   |
  @bug
  Examples:
    | number | error message         |
    | 666    | "Number is too big"   |
