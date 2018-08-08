@Task2
  Feature: Scenario Outline
    Background:
      Given I am on the jobs page

    Scenario: adding a person with a job
#      Given I am on the jobs page
      When I press the Add person button
      And I enter person data:
        | name | Test   |
        | job  | Tester |
      And I click the Add button
      Then I see the person with a name "Test" and a job "Tester"


    Scenario: editing a person with a job
#      Given I am on the jobs page
      When I press the Add person button
      And I enter person data:
        | name | Test   |
        | job  | Tester |
      And I click the Add button
      When I click the Edit person button
      And I enter person data:
        | name | Toast   |
        | job  | Toaster |
      And I click the Edit button
      Then I see the new person with a name "Toast" and a job "Toaster"


    Scenario: adding another person with a job
#      Given I am on the jobs page
      When I press the Add person button
      And I press the Add another person button
      And I enter person data:
        | name | Test   |
        | job  | Tester |
      And I click the Add button
      Then I see the person with a name "Test" and a job "Tester"


    Scenario: deleting a person
#      Given I am on the jobs page
      When I press the Add person button
      And I enter person data:
        | name | Test   |
        | job  | Tester |
      And I click the Add button
      And I press the Delete button
      Then I shouldnt see the person "Test" in the list


    Scenario: editing a person and pressing Cancel
#      Given I am on the jobs page
      When I press the Add person button
      And I enter person data:
        | name | Test   |
        | job  | Tester |
      And I click the Add button
      And I click the Edit person button
      And I click the Cancel button
      Then I see the person with a name "Test" and a job "Tester"


#    Reset works after:

    Scenario: reset after adding a person
#      Given I am on the jobs page
      When I press the Add person button
      And I enter person data:
        | name | Test   |
        | job  | Tester |
      And I click the Add button
      And I click the Reset button
      Then I shouldnt see the person "Test" in the list


    Scenario: reset after editing a person
#      Given I am on the jobs page
      When I press the Add person button
      And I enter person data:
        | name | Test   |
        | job  | Tester |
      And I click the Add button
      And I click the Edit person button
      And I click the Edit button
      And I click the Reset button
      Then I shouldnt see the person "Test" in the list


    Scenario: reset after deleting a person
#      Given I am on the jobs page
      When I press the Add person button
      And I enter person data:
        | name | Test   |
        | job  | Tester |
      And I click the Add button
      And I press the Delete button
      And I click the Reset button
      Then I shouldnt see the person "Test" in the list


