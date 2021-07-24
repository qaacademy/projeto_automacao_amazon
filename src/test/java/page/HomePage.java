package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver; 
	
	
	public final String CAMPO_BUSCA = "//input[@id='twotabsearchtextbox']"; 
	
	
	
	public HomePage(WebDriver outro_driver) {
		
		this.driver = outro_driver;
	}
	
	public void buscaProduto() {
		driver.findElement(By.xpath(CAMPO_BUSCA)).sendKeys("Kindle");
		driver.findElement(By.xpath(CAMPO_BUSCA)).submit();
	}
	
	

}
