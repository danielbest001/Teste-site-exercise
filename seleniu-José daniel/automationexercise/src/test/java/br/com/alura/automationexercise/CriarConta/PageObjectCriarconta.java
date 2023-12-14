package br.com.alura.automationexercise.CriarConta;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObjectCriarconta {
	
		private static final String URL_LOGIN = "https://automationexercise.com/login";
		private WebDriver browser;
		
		//Construtor:
		public PageObjectCriarconta() {
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
	 
		public void preencheLogin(String usuario, String email) {
			//Identendificando campos e escrevendo:
			   browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys(usuario);;
			   browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys(email);;	
		}
	 
	 
		public void submit() {
			//Submete os campos
			   browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).submit();
			
		}
		
		public void submitSemPreencher() {
			//Submete os campos
			   browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();
			
		}
	 
	 
		public void verificarMensagemdeErro() {
			 // Verifica se a mensagem de erro está sendo exibida 
	        WebElement errorMessage = browser.findElement(By.xpath(""));
	        String actualMessage = errorMessage.getText();
	        String expectedMessage = "Preencha este campo";

	        assert actualMessage.contains(expectedMessage) : "Mensagem Preencha este campo não está sendo exibida.";
		}
		
		public void preencherFormularioDeLogin( ) {
			 // password
	         browser.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("suaSenha");

	        // selecionar dia
	        browser.findElement(By.xpath("//*[@id=\"days\"]")).sendKeys("15");

	        // selecionar mes
	        browser.findElement(By.xpath("//*[@id=\"months\"]")).sendKeys("July"); 

	        // selecionar ano
	        browser.findElement(By.xpath("//*[@id=\"years\"]")).sendKeys("2000");
	        
	     // selecionar primeiro nome
	        browser.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("seuPrimeiroNome");

	        // selecionar ultimo nome
	        browser.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys("seuUltimoNome");
	        
	        // selecionar company
	        browser.findElement(By.xpath("//*[@id=\"company\"]")).sendKeys("NTT DATA");

	        // selecionar cargo
	        browser.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("QA");

	        // selecionar endereço
	        browser.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("recife,pernambuco,brasil");

	        // selecionar endereço2
	        browser.findElement(By.xpath("//*[@id=\"address2\"]")).sendKeys("recife,pernambuco,brasil,marcozero");

	        // selecionar país
	        browser.findElement(By.xpath("//*[@id=\"country\"]")).sendKeys("India");

	        // selecionar cidade
	        browser.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys("Recife");

	        // selecionar zipcode
	        browser.findElement(By.xpath("//*[@id=\"zipcode\"]")).sendKeys("7878");

	        // selecionar telefone celular
	        browser.findElement(By.xpath("//*[@id=\"mobile_number\"]")).sendKeys("81787878");
	        
		}
		
		 public void submetendoSexo() {
			 // Encontrar o elemento da opção que deseja selecionar 
		        WebElement opcaoElemento = browser.findElement(By.xpath("//*[@id=\"id_gender1\"]"));
		       // Verificar se a opção não está marcada antes de clicar nela
		        if (!opcaoElemento.isSelected()) {
		            // Clicar na opção para marcá-la
		            opcaoElemento.click();
		        }
		        
		        
		        
	    }
		 
		public void preenchendoCheckBox() {
			  // Encontrar o elemento da opção que deseja selecionar 
	        WebElement opcaoElemento11 = browser.findElement(By.xpath("//*[@id=\"optin\"]"));
	       // Verificar se a opção não está marcada antes de clicar nela
	        if (!opcaoElemento11.isSelected()) {
	            // Clicar na opção para marcá-la
	            opcaoElemento11.click();
	        }
		}
	
		
		public void checarMenssagemDeSucesso() {
			// Verifica se a mensagem de suceso está sendo exibida 
	        WebElement errorMessage = browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
	        String actualMessage = errorMessage.getText();
	        String expectedMessage = "ACCOUNT CREATED!";

	        assert actualMessage.contains(expectedMessage) : "Mensagem ACCOUNT CREATED! não está sendo exibida.";
		}


		public void submeterBotaoCriarConta() {
			// clicar no botão criar  conta 
	        browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).submit();
			
		}
	
		public boolean validarRedirecionamento() {
			//Compara URL:
			browser.getCurrentUrl().equals("https://automationexercise.com/signup");
			return false;
		}
		
		public void fazerLoginContaExistente(String usuario, String email) {
			//Identendificando campos e escrevendo:
			   browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys(usuario);;
			   browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys(email);;
		}
		
		public void checarMenssagemDeErro() {
			// Verifica se a mensagem de erro está sendo exibida 
	        WebElement errorMessage = browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p"));
	        String actualMessage = errorMessage.getText();
	        String expectedMessage = "Email Address already exist!";

	        assert actualMessage.contains(expectedMessage) : "Mensagem Email Address already exist! não está sendo exibida.";
	        
	      
		}
		
		public void checarMenssagemDeErro2() {
			// Verifica se a mensagem de erro está sendo exibida 
	        WebElement errorMessage = browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
	        String actualMessage = errorMessage.getText();
	        String expectedMessage = "ACCOUNT CREATED!";

	        assert actualMessage.contains(expectedMessage) : "Mensagem ACCOUNT CREATED! não está sendo exibida.";
	        
	      
		}

		public void criarEmailAutomaticamente() {
			
			// Gerar email aleatório
			String email = "user" + RandomStringUtils.randomAlphanumeric(5) + "@example.com";

			// Gerar senha aleatória
			String senha = RandomStringUtils.randomAlphanumeric(8);

			// Preencher campos no formulário
			browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys(email);
			browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys(senha);
		}
}
