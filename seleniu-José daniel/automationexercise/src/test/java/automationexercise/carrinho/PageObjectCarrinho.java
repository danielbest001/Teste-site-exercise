package automationexercise.carrinho;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PageObjectCarrinho {

	private static final String URL_LOGIN = "https://automationexercise.com/login";
	private WebDriver browser;
	
	//Construtor:
	
	public PageObjectCarrinho() {
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
	
	public void fazerLoginComContaExistente(String email, String senha) {
		//Identendificando campos e escrevendo:
		   browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys(email);;
		   browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys(senha);;
	}
	
	public void submitLogin() {
		//Submete os campos
		   browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).submit();
}
	
	public void adicionarProdutoAoCarrinho() {
		 // Localizar o botão de adicionar ao carrinho 
        browser.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]/a")).click();

        
     // Aguardar um tempo curto para a ação ser concluída 
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

	}
	
	
	
	public void checarMenssagemDeSucessoCarrinho() {
		// Verifica se a mensagem de erro está sendo exibida 
        WebElement Message = browser.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[1]/h4"));
        String actualMessage = Message.getText();
        String expectedMessage = "Added!";

        assert actualMessage.contains(expectedMessage) : "Mensagem Added! não está sendo exibida.";
	}
	
	public void passeMouseSobrePoduto() {
		 WebElement mouse = browser.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/img"));
	        Actions actions = new Actions(browser);
	        actions.moveToElement(mouse).build().perform();
		
	}
	
}
