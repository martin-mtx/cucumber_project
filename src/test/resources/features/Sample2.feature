@regression
Feature: Introduction to cucumber part 2
  As a test engineer
  I want to be able to write and execute a scenario with parameters

  Scenario: a new scenario 1 with regex
    Given I am on age page
    When I enter name: "Ann"
    And I enter age: 5
    And I click submit age
    Then I see message: "Hello, Ann, you are a kid"

  Scenario: a new scenario 2 with regex
    Given I open age page
    When I enter name: "Bob"
    And I enter age: 61
    And I click submit age
    Then I see message: "Hello, Bob, you are an adult"

  Scenario: my first scenario
    Given I am on Action Page
    When I enter number 7 in number field
    And I press result
    Then message "You entered number: "7"" is seen

  @sample2
  Scenario Outline: my first scenario
    Given I am on Action Page
    When I enter number <number> in number field
    And I press result
    Then message "You entered number: "<number>"" is seen
    Examples:
      | number |
      | 7      |
    Examples:
      | number |
      | 51     |
  @part2
  Scenario: Enter a number 1
    Given I am on task page
    When I enter number: 35
    Then I should see an error: "Number is too small"
