package appiumproject.pageOjects;

import appiumproject.utils.AndroidActions;
import io.appium.java_client.android.Activity;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class FormPage extends AndroidActions {

	AndroidDriver driver ;
	public FormPage(AndroidDriver driver) {
		    
		    super(driver);
			this.driver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver) ,this);
		
	}

	
	
	//driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("Achal");
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter name here']")
	private WebElement nameField;
	
	 //driver.findElement(AppiumBy.xpath("//android.widget.RadioButton[@text='Female']")).click();
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
	private WebElement femaleGender;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
	private WebElement maleGender;
	
//	 driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Afghanistan']")).click();
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Afghanistan']")
	private WebElement countryField;
   
//	   driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button")).click();
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button")
	private WebElement letShopButton;
	
	
	
	
	public void countrySelection(String country) {
		
		countryField.click();
		System.out.println("****** Clicked on country dropdown list ********");
	    scrollToCountry(country);
		
	}
	
	
	public void setNameField(String name) {

		sendkeys(nameField, name);  //sendkeys method is called from AndroidActions class with wait
		//nameField.sendKeys(name);  //simple simple sendkeys
		driver.hideKeyboard();
		System.out.println("****** Entered name in 'Your Name' field ********");
		 System.out.println("****** Keyboard is hide ********");
	}
	
	public void setGender(String gender) {
		
		if(gender.contains("Female")) {
		     femaleGender.click();
		     System.out.println("****** Gender 'Female' is selected ********");
		}    
		else 
			maleGender.click();
	}
	
	public ProductCatalogue letsShopButtonclick() {
		
		letShopButton.click();
		System.out.println("****** Clicked on 'Let's shop' to submit form ********");
		//Implement Page object file for Product Catalogue page with actions
		//return as product catalogue page object
		return new ProductCatalogue(driver);
	}

	public void setActivity(){

		activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.SplashActivity");

		System.out.println("******************* get Package before start activity ****************"+activity.getAppPackage());
		System.out.println("******************* get Activity before start activity ****************"+activity.getAppActivity());

		driver.startActivity(activity); //start activity
		System.out.println("******************* start activity run ****************");

	}
}
