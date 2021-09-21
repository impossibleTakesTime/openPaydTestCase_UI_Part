package openPayd.pages;

import openPayd.utilities.BrowserUtils;
import openPayd.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class ProductionsPage {
    public ProductionsPage() {

        PageFactory.initElements(Driver.get(), this);

    }

    @FindBy(css = ".a-size-medium")
    public List<WebElement> allProductionsName;

    @FindBy(css = "#productTitle")
    public WebElement theProductionsName;

    @FindBy(css = "span.priceBlockStrikePriceString")
    public WebElement listPrice;

    @FindBy(css = "span.a-size-small.a-color-secondary")
    public WebElement shipToTurkey;

    @FindBy(css = "#price_inside_buybox")
    public WebElement thePrice;

    @FindBy(css = "#add-to-cart-button")
    public WebElement addToTheCart;

    @FindBy(css = ".a-button-input")
    public WebElement addCartButton;

    ArrayList shoppingList = new ArrayList();

    public void yazdir() {

        System.out.println("allProductionsName.size() = " + allProductionsName.size());
        int listPriceNum=0;
        for (int i = 0; i < allProductionsName.size(); i++) {
            //BrowserUtils.waitFor(1);
            //System.out.print("allProductionsName.getText() = " + allProductionsName.get(i).getText() + " | ");
            BrowserUtils.waitFor(2);
            allProductionsName.get(i).click();

            try {
                //System.out.println("listPrice.getText() = " +
                listPrice.getText();
                listPriceNum ++;
                //System.out.println("Burdayım...");
                Driver.get().navigate().back();
                BrowserUtils.waitFor(2);
            } catch (Exception e) {
               // System.out.println("There is no discount here...");
                try {
                    thePrice.getText();
                    BrowserUtils.waitFor(3);
                      try {
                          String temp=(theProductionsName.getText());
                          if(temp.contains("RAM")||temp.contains("DDR")||temp.contains("SSD")||temp.contains("HDD")) {
                              BrowserUtils.waitFor(2);
                              addToTheCart.click();
                              shoppingList.add(temp);
                              BrowserUtils.waitFor(2);

                          }
                          System.out.println("temp = " + temp);
                          BrowserUtils.waitFor(2);
                      }catch (Exception shippable){
                         System.out.println("This item is not a shippable item");
                      }

                } catch (Exception noPrice) {
                  System.out.println("There is a product without any price");
                }

                try {
                    addCartButton.click();
                } catch (Exception PopUp) {
                     Driver.get().navigate().back();
                    BrowserUtils.waitFor(2);
                }


                BrowserUtils.waitFor(2);
                Driver.get().get("https://www.amazon.com/s?k=Laptop&ref=nb_sb_noss_2");
            }

        }
        System.out.println("listPriceNum = " + listPriceNum);
        System.out.println("shoppingList = " + shoppingList.toString());
        System.out.println("shoppingList = " + shoppingList.size());

    }
}

