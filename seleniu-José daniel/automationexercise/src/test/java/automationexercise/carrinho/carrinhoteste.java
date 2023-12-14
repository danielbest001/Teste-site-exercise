package automationexercise.carrinho;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class carrinhoteste {
	
	private PageObjectCarrinho paginaDeCarrinho;
	@Before
	 public void Before () {
		 this.paginaDeCarrinho = new PageObjectCarrinho ();
	 }
	
	 @After
	 
	 public void After () {
		 this.paginaDeCarrinho.fecharBrowser();
	 }
		
	 @Test
	    public void testcarrinho() {
		 
		 //Entrar em uma conta existente
		 paginaDeCarrinho.fazerLoginComContaExistente("daniel@teste", "suaSenha");
		 
		 //Aperdar no botão de login
		 paginaDeCarrinho.submitLogin();
		
		 //Passar o mouse sobre o Produto
		 paginaDeCarrinho.passeMouseSobrePoduto();
		
		 //Adicionar o produto ao carrinho
		 paginaDeCarrinho.adicionarProdutoAoCarrinho();
		
		 // checar se a mensagem de sucesso "Added!" é exibida
		 paginaDeCarrinho.checarMenssagemDeSucessoCarrinho();
		 
	 }
	 
	 
	}


