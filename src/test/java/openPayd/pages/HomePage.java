package openPayd.pages;

import openPayd.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(){

        PageFactory.initElements(Driver.get(), this);

    }

    @FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
    public WebElement searchBox;
    @FindBy(xpath = "//*[@id=\"nav-search-bar-form\"]/div[3]/div")
    public WebElement searchIcon;

    public void setSearchBox(String str){
        searchBox.sendKeys(str);
        searchIcon.click();
    }
    public void checkThePage(){
        String title=Driver.get().getTitle();
        Assert.assertTrue(title.contains("Amazon.com"));
    }
}
