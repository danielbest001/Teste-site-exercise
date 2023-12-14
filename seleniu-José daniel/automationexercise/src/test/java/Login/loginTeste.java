package Login;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class loginTeste {
	
	private PageObjectLogin paginaDeLogin2;
	
	//atributo:
	
	@Before
	 public void Before () {
		 this. paginaDeLogin2 = new  PageObjectLogin ();
	 }
	
	 @After
	 
	 public void After () {
		 this.paginaDeLogin2.fecharBrowser();
	 }
	 
	 @Test
	    public void testeLogin() {
		 
		 //Fazer login com usuario cadastrado
		 paginaDeLogin2.fazerLoginContaExistente("daniel@teste", "suaSenha");
		 
		//Apertar o botão para entrar na conta
		 paginaDeLogin2.submitLoginTela();
		 
		 paginaDeLogin2.checarMenssagemSucessoCarrinho();
		 
		// comparando URL
	        Assert.assertFalse(paginaDeLogin2.validarRedirecionamento());
	 }
	 
	 @Test
	    public void LoginInconrreto() {
		 //Fazer login com usuario cadastrado
		 paginaDeLogin2.fazerLoginContaExistente("daniel@teste","dlfdlfdd");
		//Apertar o botão para entrar na conta
		 paginaDeLogin2.submitLoginTela();
		 //checar mensagem de erro
		 paginaDeLogin2.checarMenssagemDeLoginIncorreto();;
	 }

}
