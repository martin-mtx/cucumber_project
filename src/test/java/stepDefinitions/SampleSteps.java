package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.gl.E;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/test-sample");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/test-sample/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"(.*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
        }
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I am on page locator$")
    public void iAmOnPageLocator() throws Throwable {
        driver.get("https://kristinek.github.io/test-sample/examples/loc");
        assertEquals("https://kristinek.github.io/test-sample/examples/loc",
                driver.getCurrentUrl());
    }

    @Then("^I should see heading two text$")
    public void i_should_see_heading_two_text() throws Throwable {
        assertTrue(driver.findElement(By.id("heading_2")).isDisplayed());
        assertEquals("Heading 2", driver.findElement(By.id("heading_2")).getText());
    }

    @Then("^I should see a heading text$")
    public void iShouldSeeAHeadingText() throws Throwable {
        assertTrue(driver.findElement(By.id("heading_1")).isDisplayed());
        assertEquals("Heading 1",
                driver.findElement(By.xpath("//h2[1]")).getText());
    }

    @And("^I change age to (\\d+)$")
    public void iChangeAgeTo(int age) throws Throwable {
        String newAge = String.valueOf(age);
        driver.findElement(By.id("age")).clear();
        driver.findElement(By.id("age")).sendKeys(newAge);
    }

    @And("^I change name to \"([^\"]*)\"$")
    public void iChangeNameTo(String blabla) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(blabla);
    }

    @Given("^I am on task page$")
    public void iAmOnTaskPage() throws Throwable {
        driver.get("https://kristinek.github.io/test-sample/tasks/task1");
        assertEquals("https://kristinek.github.io/test-sample/tasks/task1",
                driver.getCurrentUrl());
    }

    @When("^I enter number: (\\d+)$")
    public void iEnterNumber(int aNumber12) throws Throwable {
        String number = String.valueOf(aNumber12);
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(number);
        driver.findElement(By.xpath("//*[@type='button']")).click();
    }


    @Given("^I am on Action Page$")
    public void i_am_on_Action_Page() throws Throwable {
        driver.get("https://kristinek.github.io/test-sample/examples/act");
    }

    @When("^I enter number (\\d+) in number field$")
    public void i_enter_number_in_number_field(int number) throws Throwable {
        WebElement numberField = driver.findElement(By.id("number"));
        numberField.clear();
        numberField.sendKeys(String.valueOf(number));
    }

    @When("^I press result$")
    public void i_press_result() throws Throwable {
        driver.findElement(By.id("result_button_number")).click();
    }

//    @Then("^message \"([^\"]*)\"(\\d+)\"\" is seen$")
//    public void message_is_seen(String messageStart, int numberInMessage) throws Throwable {
//        // "You entered number: "7"" ->
//        assertEquals(messageStart + '"' + numberInMessage + '"',
//                driver.findElement(By.id("result_number")).getText());
//    }

    @Then("^message \"(.*)\" is seen$")
    public void message_is_seen(String message) throws Throwable {
        // "You entered number: "7"" ->
        assertEquals(message,
                driver.findElement(By.id("result_number")).getText());
    }

    @Then("^I should see an error: \"([^\"]*)\"$")
    public void iShouldSeeAnError(String errorText) throws Throwable {
        assertEquals(errorText, driver.findElement(By.id("ch1_error")).getText());
    }

//  Task 1 ______________________________________________________________________________

    @Given("^I am on the Feedback page$")
    public void I_am_on_the_Feedback_page() throws Throwable {
        driver.get("https://kristinek.github.io/test-sample/tasks/task4");
    }

    @When("^I enter name on the Feedback page: \"([^\"]*)\"$")
    public void I_enter_name_on_the_Feedback_page(String name) throws Throwable {
        driver.findElement(By.id("fb_name")).clear();
        driver.findElement(By.id("fb_name")).sendKeys(name);
    }

    @When("^I choose my language$")
    public void I_choose_my_language() throws Throwable {
        driver.findElement(By.cssSelector(".w3-check[type='checkbox'][value='Chinese']")).click();
    }

    @When("^I choose my two languages$")
    public void I_choose_my_two_languages() throws Throwable {
        driver.findElement(By.cssSelector(".w3-check[type='checkbox'][value='Chinese']")).click();
        driver.findElement(By.cssSelector(".w3-check[type='checkbox'][value='French']")).click();
    }

    @And("^I click Send$")
    public void I_click_Send() throws Throwable {
        driver.findElement(By.cssSelector(".w3-btn-block.w3-blue.w3-section[type='submit']")).click();
    }

    @And("^I click Yes")
    public void I_click_Yes() throws Throwable {
        driver.findElement(By.cssSelector(".w3-btn.w3-green.w3-xlarge[onclick='openFeedback()']")).click();
    }

    @Then("^Message \"(.*)\" is seen$")
    public void Check_Thank_You_Page(String message) {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @Then("^I see language message: \"([^\"]*)\"$")
    public void I_see_language_message(String myOneLanguage) throws Throwable {
        assertEquals(myOneLanguage, driver.findElement(By.cssSelector("div.description:nth-child(3) > p")).getText());
    }

    @Then("^I see two language message: \"([^\"]*)\"$")
    public void I_see_two_language_message(String myOneLanguage) throws Throwable {
        assertEquals(myOneLanguage, driver.findElement(By.cssSelector("div.description:nth-child(3) > p")).getText());
    }

//  Sample  ______________________________________________________________________________

    @When("^I enter data:$")
    public void I_enter_data(Map<String, String> DataToEnter) throws Throwable {
        for (Map.Entry<String, String> e : DataToEnter.entrySet()) {
            driver.findElement(By.name(e.getKey())).clear();
            driver.findElement(By.name(e.getKey())).sendKeys(e.getValue());
        }
    }

    @Then("^I see text:$")
    public void I_see_text_on_the_feedback_page(Map<String, String> DataToCheck) throws Throwable {
        for (Map.Entry<String, String> e : DataToCheck.entrySet()) {
            assertEquals(e.getValue(), driver.findElement(By.id(e.getKey())).getText());
        }
    }
//  Task 2 ______________________________________________________________________________

    @Given("^I am on the jobs page$")
    public void I_am_on_the_jobs_page() throws Throwable {
        driver.get("https://kristinek.github.io/test-sample/tasks/task3");
    }

    @When("^I press the Add person button$")
    public void I_press_the_Add_person_button() throws Throwable {
        driver.findElement(By.id("addPersonBtn")).click();
    }

    @And("^I enter person data:$")
    public void I_enter_person_data(Map<String, String> DataToEnter) throws Throwable {
        for (Map.Entry<String, String> e : DataToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
        }
    }

    @And("^I click the Add button$")
    public void I_click_the_Add_button() throws Throwable {
        driver.findElement(By.id("modal_button")).click();
    }

    @Then("^I see the person with a name \"(.*)\" and a job \"(.*)\"$")
    public void I_see_the_person(String name, String job){
        assertEquals(name, driver.findElement(By.xpath("//*[@id='person3']/span[@class='w3-xlarge name']")).getText());
        assertEquals(job, driver.findElement(By.xpath("//*[@id='person3']/span[@class='job']")).getText());
    }

    @Then("^I see the new person with a name \"(.*)\" and a job \"(.*)\"$")
    public void I_see_the_new_person(String Name, String Job){
        assertEquals(Name, driver.findElement(By.xpath("//*[@id='person3']/span[@class='w3-xlarge name']")).getText());
        assertEquals(Job, driver.findElement(By.xpath("//*[@id='person3']/span[@class='job']")).getText());
    }

    @And("^I click the Edit person button$")
    public void I_click_the_Edit_person_button() throws Throwable {
        driver.findElement(By.cssSelector("[onclick='openModalForEditPerson(3)']")).click();
    }

    @When("^I click the Edit button$")
    public void I_click_the_Edit_button() throws Throwable {
        driver.findElement(By.id("modal_button")).click();
    }

    @And("^I press the Add another person button$")
    public void I_click_Edit_button() throws Throwable {
        driver.findElement(By.id("addPersonBtn")).click();
    }

    @And("^I press the Delete button$")
    public void I_press_the_Delete_button() throws Throwable {
        driver.findElement(By.cssSelector("[onclick='deletePerson(3)']")).click();
    }

    @And("^I click the Cancel button$")
    public void I_click_the_Cancel_button() throws Throwable {
        driver.findElement(By.cssSelector("[onclick='window.history.back()']")).click();
    }

    @Then("^I shouldnt see the person \"(.*)\" in the list$")
    public void I_shouldnt_see_the_person_in_the_list(String name) throws Throwable {
        driver.findElements(By.xpath("//*[@class='w3-xlarge name' and text()='"+name +"']")).size();
        assertEquals(0, driver.findElements(By.xpath("//*[@class='w3-xlarge name' and text()='"+name +"']")).size());
    }

    @And("^I click the Reset button$")
    public void I_click_the_Reset_button() throws Throwable {
        driver.findElement(By.cssSelector("[onclick='resetListOfPeople()']")).click();
    }

}

