package fazerCompra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class pageObjectCompra {

	
	private static final String URL_LOGIN = "https://automationexercise.com/login";
	private WebDriver browser;
	
	//Construtor:
	
	public pageObjectCompra() {
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
        browser.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/a")).click();
        
     // Aguardar um tempo curto para a ação ser concluída 
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

	}
	
	
	
	
	public void passeMouseSobrePoduto() {
		 WebElement produto = browser.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/img"));
	        Actions actions = new Actions(browser);
	        actions.moveToElement(produto).build().perform();
		
	}
 
	// apertar botão para visualizar acrrinho
	 public void visualizarCarrinho() {
		// Localize o botão e clique diretamente nele
		browser.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")).click();

	 }
	
	 // botão de processar compras
	 public void processarCompras() {
		 browser.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a")).click();
	 }
	 
	 //comentario sobre a compra
	 public void comentarioSobreCompra() {
		 browser.findElement(By.xpath("//*[@id=\"ordermsg\"]/textarea")).sendKeys("Gostei da roupa");
	 }
	 
	 //Fazer pedido
	 public void fazerPedido() {
		 browser.findElement(By.xpath("//*[@id=\"cart_items\"]/div/div[7]/a")).click();
	 }
	 
	 //Medoto de pagamento
	 public void metodoDePagamento() {
		// Nome do cartão
	        browser.findElement(By.xpath("//*[@id=\"payment-form\"]/div[1]/div/input")).sendKeys("Jose Daniel"); 

	        // Número de cartão
	        browser.findElement(By.xpath("//*[@id=\"payment-form\"]/div[2]/div/input")).sendKeys("15141314");

	        // CVC
	        browser.findElement(By.xpath("//*[@id=\"payment-form\"]/div[3]/div[1]/input")).sendKeys("434"); 

	        // mes que expira
	        browser.findElement(By.xpath("//*[@id=\"payment-form\"]/div[3]/div[2]/input")).sendKeys("06");
	        
	     // ano que expira
	       browser.findElement(By.xpath("//*[@id=\"payment-form\"]/div[3]/div[3]/input")).sendKeys("seuPrimeiroNome");
	 }
	 
	 // botão para validar metodo de pagamento
	 public void BotaoMedotodepagamento() {
		 browser.findElement(By.xpath("//*[@id=\"submit\"]")).click();
	 }
	 
	 //verificar mensagem de compra finalizada
	 public void ValidarMensagemDeCompraFinalizada() {
		
	        WebElement errorMessage = browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
	        String actualMessage = errorMessage.getText();
	        String expectedMessage = "ORDER PLACED!";

	        assert actualMessage.contains(expectedMessage) : "Mensagem ORDER PLACED! não está sendo exibida.";
		}
	 
}
