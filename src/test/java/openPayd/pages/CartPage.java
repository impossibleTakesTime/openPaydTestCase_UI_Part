package openPayd.pages;


import openPayd.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;


public class CartPage {

    public CartPage() {

        PageFactory.initElements(Driver.get(), this);

    }
    @FindBy (css= "#nav-cart-count")
    public WebElement clickCart;

    @FindBy (css= ".a-truncate-cut")
    public List<WebElement> cartProductsName;

    ProductionsPage productionsPage=new ProductionsPage();

    ArrayList cartList = new ArrayList();


        public void checkCart(){
        clickCart.click();
        for (int i=0; i<cartProductsName.size(); i++)
        cartList.add(cartProductsName.get(i).getText());
        System.out.println("cartList = " + cartList.toString());
        System.out.println("cartList = " + cartList.size());

       }
       public void checkItemsAreRight(){
           Assert.assertEquals(productionsPage.shoppingList.size(),cartList.size());
           System.out.println("The number is same");
           for(int i=0; i<cartList.size(); i++){
               Assert.assertTrue(productionsPage.shoppingList.contains(cartList.get(i)));
           }
       }


}

