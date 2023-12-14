package br.com.alura.automationexercise.CriarConta;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class testCriarConta {

	//atributo:
	
	private PageObjectCriarconta paginadelogin;
	  
	
	@Before
	 public void Before () {
		 this.paginadelogin = new PageObjectCriarconta ();
	 }
	
	 @After
	 
	 public void After () {
		 this.paginadelogin.fecharBrowser();
	 }
	   
	    @Test
	    public void criarContaSemPreencherOsCamposObrigatorios() {
	        // Preenche o nome e o email 
	        paginadelogin.criarEmailAutomaticamente();


	        // Encontra o formulário e envia 
	            paginadelogin.submit();

	        // Tenta criar a conta sem preencher campos obrigatórios 
	        paginadelogin.submitSemPreencher();

	        // Verifica se a mensagem de erro está sendo exibida 
	       // paginadelogin.verificarMensagemdeErro();
	     
	     // comparando URL
	         Assert.assertTrue(paginadelogin.validarRedirecionamento());
	    }
 
	    @Test
	    public void criarContaPreencheendoOsCamposObrigatorios() {
	    	// Preenche o nome e o email 
	        paginadelogin.criarEmailAutomaticamente();

	        // Encontra o formulário e envia 
	            paginadelogin.submit();
	            
	            //Selecionar sexo do usuario 
	            paginadelogin.submetendoSexo();
	            
	            //Preencher requisitos obrogatorios do formulario
	            paginadelogin.preencherFormularioDeLogin();
	            
	            paginadelogin.preenchendoCheckBox();
	            
	            // clicar no botão criar  conta 
	            paginadelogin.submeterBotaoCriarConta();
	            
	         // Verifica se a mensagem de erro está sendo exibida
	            paginadelogin.checarMenssagemDeErro2();
	    	// comparando URL
	         Assert.assertFalse(paginadelogin.validarRedirecionamento());
	    }
	        
	    @Test
	    public void testeCriarcontaComEmailExistente() {
	    	//Fazer login com email e senha validos 
	    	paginadelogin.fazerLoginContaExistente("daniel","daniel@teste");
	    	//Apertar no botão para fazer login
	    	paginadelogin.submit();
	    	//checar mensagem de erro de conta existente
	    	paginadelogin.checarMenssagemDeErro();
	    }
  }        
	    
	    
	    
	
	   
	        

	