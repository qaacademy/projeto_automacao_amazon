package testes;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import page.HomePage;
import page.ResultadoBuscaPage;

public class TesteBuscaAmazon {

	static ChromeDriver driver;
	static HomePage homePage;
	static ResultadoBuscaPage resultadoBuscaPage;

	@BeforeClass
	public static void beforeClass() {
		driver = setupChromeDriver();
		driver.get("https://www.amazon.com.br/");// Abrindo uma pagina

		homePage = new HomePage(driver);
		resultadoBuscaPage = new ResultadoBuscaPage(driver);

	}

	@Test
	public void testeBuscaProdutoAmazon() {
		
		homePage.buscaProduto();
		resultadoBuscaPage.clicarProduto();
		resultadoBuscaPage.validarProdutoNatela();

	}

//	@AfterClass
//	public static void AfterClass() {
//		
//		driver.quit();
//	}

	public static ChromeDriver setupChromeDriver() {

		ChromeOptions chromeOptions = new ChromeOptions();
		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}

}
