package testes;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import page.CarrinhoPage;
import page.HomePage;
import page.ResultadoBuscaPage;

public class TesteBuscaAmazon {

	static ChromeDriver driver;
	
	HomePage homePage = new HomePage(driver);
	ResultadoBuscaPage resultadoBuscaPage = new ResultadoBuscaPage(driver);
	CarrinhoPage carrinhoPage = new CarrinhoPage(driver);
	

	@BeforeClass
	public static void beforeClass() {
		driver = setupChromeDriver();
		driver.get("https://www.amazon.com.br/");// Abrindo uma pagina

		

	}

	public void testeBuscaProdutoAmazon() {
		
		homePage.buscaProduto();
		resultadoBuscaPage.clicarProduto();
		resultadoBuscaPage.validarProdutoNatela();

	}
	
	
	@Test
	public void testeBuscaCarrinhoProdutoAmazon() {
		
		homePage.buscaProduto();
		resultadoBuscaPage.clicarProduto();
		carrinhoPage.adicionarCarrinho();
		carrinhoPage.pularRecomendacao();
		carrinhoPage.adicionarCarrinho();
		carrinhoPage.clicarCarrinho();
		carrinhoPage.validarProdutoNoCarrinho();
	}

//	@AfterClass
//	public static void AfterClass() {
//		
//		driver.quit();
//	}

	public static ChromeDriver setupChromeDriver() {

		ChromeOptions chromeOptions = new ChromeOptions();
		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}

}
