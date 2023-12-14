package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObjectLogin {

	private static final String URL_LOGIN = "https://automationexercise.com/login";
	private WebDriver browser;
	
	//Construtor:
	
	public PageObjectLogin() {
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
 
	public void fazerLoginContaExistente(String email, String senha) {
		//Identendificando campos e escrevendo:
		   browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys(email);;
		   browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys(senha);;
	}
	
	public void submitLoginTela() {
		//Submete os campos
		   browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).submit();
	
	
}

	
	public void checarMenssagemSucessoCarrinho() {
		// Verifica se a mensagem de erro está sendo exibida 
        WebElement errorMessage = browser.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        String actualMessage = errorMessage.getText();
        String expectedMessage = "Logged in as daniel";

        assert actualMessage.contains(expectedMessage) : "Mensagem Logged in as daniel não está sendo exibida.";
	}
	
	public boolean validarRedirecionamento() {
		//Compara URL:
		browser.getCurrentUrl().equals("https://automationexercise.com/signup");
		return false;
	}


    public void checarMenssagemDeLoginIncorreto() {
    	// Verifica se a mensagem de erro está sendo exibida 
        WebElement loginIncorreto = browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p"));
        String menssagemAtual = loginIncorreto.getText();
        String mebssagemEsperada = "Your email or password is incorrect!";
}
	
		
	}
	
