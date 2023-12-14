package Pesquisarproduto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class pageObjectPesquisarProduto {

	private static final String URL_LOGIN = "https://automationexercise.com/products";
	private WebDriver browser;
	
	//Construtor:
	
	public pageObjectPesquisarProduto() {
		//Caminho do ChromeDriver:
		   System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		   
		 //Variável para abrir o browser:
		   this.browser = new ChromeDriver();
		   
	    //Passando URL:
		   browser.navigate().to(URL_LOGIN);
	}
 
	
	
	//Para fechar o browser:
	public void fecharBrowser() {
		   this.browser.quit();
	}
	
		
	public void pesquisarProduto() {
		 // pesquisar produto
       browser.findElement(By.xpath("//*[@id=\"search_product\"]")).sendKeys("Men Tshirt"); 
	}
	
	public void submitPesquisa() {
		 // 4. Click no botão de pesquisa
      browser.findElement(By.xpath("//*[@id=\"submit_search\"]")).click();
	}
	

	public void checarProduto() {
		// Verifica se a mensagem de erro está sendo exibida 
        WebElement errorMessage = browser.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]/p"));
        String actualMessage = errorMessage.getText();
        String expectedMessage = "Men Tshirt";

        assert actualMessage.contains(expectedMessage) : "Mensagem Men Tshirt não está sendo exibida.";
	}
}