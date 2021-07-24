package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarrinhoPage {

	WebDriver driver;

	public CarrinhoPage(WebDriver outro_driver) {

		this.driver = outro_driver;
	}

	public final String BTN_ADD_CARRINHO = "//input[@id='add-to-cart-button']";
	
	public final String BTN_NAO_OBRIGADO = "//*[contains(text(),'Não,')]"; 
	public final String BTN_CARRINHO = "//span[@id='nav-cart-count']"; 
	public final String BTN_FECHAR_PEDIDO = "//*[@id='sc-buy-box-ptc-button']/span/input";
	public final String PRODUTO = "//span[contains(text(),'Kindle 10a. geração com iluminação embutida – Cor ')]";
	
	
	public final String LOGO_AMAZON = "//*[@id='nav-logo-sprites']"; 
	

	
	

	public void adicionarCarrinho() {
		driver.findElement(By.xpath(BTN_ADD_CARRINHO)).click();
	}
	
	public void pularRecomendacao() {
		
		if (driver.getPageSource().contains("Não, obrigado(a)")) {
//			driver.navigate().refresh();	
//			driver.findElement(By.xpath(BTN_NAO_OBRIGADO)).click();
			driver.findElement(By.xpath(LOGO_AMAZON)).click();
			
		}
	}
	

	public void clicarCarrinho() {
		driver.findElement(By.xpath(BTN_CARRINHO)).click();
	}
	
	
	public void validarProdutoNoCarrinho() {
		
		Assert.assertTrue("Erro ao validar produto", driver.getPageSource().contains("Fechar Pedido"));
		
	}
	

}
