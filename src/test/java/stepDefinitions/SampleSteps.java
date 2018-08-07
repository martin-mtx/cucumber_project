package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

//  ______________________________________________________________________________

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

    @And ("^I click Send$")
    public void I_click_Send() throws Throwable {
        driver.findElement(By.cssSelector(".w3-btn-block.w3-blue.w3-section[type='submit']")).click();
    }

    @And ("^I click Yes")
    public void I_click_Yes() throws Throwable {
        driver.findElement(By.cssSelector(".w3-btn.w3-green.w3-xlarge[onclick='openFeedback()']")).click();
    }

    @Then("^Message \"(.*)\" is seen$")
    public void Check_Thank_You_Page(String message){
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





}