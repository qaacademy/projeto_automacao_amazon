package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultadoBuscaPage {

	WebDriver driver;

	public ResultadoBuscaPage(WebDriver outro_driver) {

		this.driver = outro_driver;
	}

	public final String PRODUTO = "//span[contains(text(),'Kindle 10a. geração com iluminação embutida – Cor ')]";
	
	
	public final String PRODUTO_RESULTADO = "//span[@id='productTitle']"; 

	public void clicarProduto() {
		driver.findElement(By.xpath(PRODUTO)).click();
	}
	
	public void validarProdutoNatela() {
		
		Assert.assertTrue("Erro ao validar produto", driver.findElement(By.xpath(PRODUTO_RESULTADO)).getText().contains("Kindle 10a"));
		
	}
	

}
