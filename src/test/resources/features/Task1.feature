@Task1
Feature: Scenario Outline

@language1
  Scenario: for selecting 1 language
    Given I am on the Feedback page
    When I choose my language
    And I click Send
    Then I see language message: "Your language: Chinese"

@language2
  Scenario: for selecting 2 languages
    Given I am on the Feedback page
    When I choose my two languages
    And I click Send
    Then I see two language message: "Your language: French,Chinese"

@messages
  Scenario Outline: : Task4 scenario_outline
    Given I am on the Feedback page
    When I enter name on the Feedback page: "<name>"
    And I click Send
    And I click Yes
    Then I see message: "<message>"
    Examples:
      | name | message |
      | Ann  | Thank you, Ann, for your feedback!|
      | Tom  | Thank you, Tom, for your feedback!|
      |      | Thank you for your feedback!      |


@Task5
Scenario: feedback 2
  Given I am on the Feedback page
  When I enter data:
    | name | Ann |
    | age  | 52  |
  And I click Send
  Then I see text:
    | name | Ann |
    | age  | 52  |

@Task6
  Scenario Outline: feedback 2
    Given I am on the Feedback page
    When I enter data:
      | name | <name> |
      | age  | <age>  |
    And I click Send
    Then I see text:
      | name | <name> |
      | age  | <age>  |
    Examples:
      | name | age |
      | Ann  | 52  |
      | Tom  | 54  |