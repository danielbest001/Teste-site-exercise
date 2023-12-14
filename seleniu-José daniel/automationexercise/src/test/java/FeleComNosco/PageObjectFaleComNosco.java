package FeleComNosco;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class PageObjectFaleComNosco {
	private static final String URL_LOGIN = "https://automationexercise.com/contact_us";
	private WebDriver browser;
	
	//Construtor:
	
	public PageObjectFaleComNosco() {
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
	
	
	
	
	public void formularioContato() {
		 // Usuario
        browser.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input")).sendKeys("Daniel"); //

        // Email
        browser.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[2]/input")).sendKeys("daniel@java");
        
        // Assunto
        browser.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[3]/input")).sendKeys("Erro de compra"); 

        // sua mensagem aqui
        browser.findElement(By.xpath("//*[@id=\"message\"]")).sendKeys("erro de compra de roupas de x marca");
      
	}
       
	
	public void submitReclamaçao() {
		 // 4. Click on 'Contact Us' button
       browser.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input")).click();
	}
	
	public void capiturandoAlerta() {
		  // Aguardar o alerta aparecer (pode ser necessário ajustar o tempo dependendo da aplicação)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Lidar com o alerta
        Alert alert = browser.switchTo().alert();
        System.out.println("Press OK to proceed!: " + alert.getText());

        // Aceitar o alerta (clicar em "OK")
        alert.accept();
	}
	
	public void checarMenssagemDeSucessoCarrinho() {
		// Verifica se a mensagem de erro está sendo exibida 
        WebElement errorMessage = browser.findElement(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]"));
        String actualMessage = errorMessage.getText();
        String expectedMessage = "Success! Your details have been submitted successfully.";

        assert actualMessage.contains(expectedMessage) : "Mensagem Success! Your details have been submitted successfully. não está sendo exibida.";
	}   
        

    
}
