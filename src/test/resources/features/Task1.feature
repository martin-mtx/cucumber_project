@Task4
Feature: Scenario Outline

  Scenario: for selecting 1 language
    Given I am on the Feedback page
    When I choose my language
    And I click Send
    Then I see language message: "Your language: Chinese"


  Scenario: for selecting 2 languages
    Given I am on the Feedback page
    When I choose my two languages
    And I click Send
    Then I see two language message: "Your language: French,Chinese"


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

