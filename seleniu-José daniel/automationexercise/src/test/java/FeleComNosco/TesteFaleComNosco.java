package FeleComNosco;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesteFaleComNosco {

private PageObjectFaleComNosco paginaDeFaleComNosco;
	
	//atributo:
	
	@Before
	 public void Before () {
		 this.paginaDeFaleComNosco = new  PageObjectFaleComNosco ();
	 }
	
	 @After
	 
	 public void After () {
		 this.paginaDeFaleComNosco.fecharBrowser();
	 }
	 
	 @Test
	    public void testeFaleComNosco() throws InterruptedException {
		 
		 //Digitar as infomções de cadastro E escrever a mensagem 
		 paginaDeFaleComNosco.formularioContato();
		 // apertar no botão para submeter reclamação
		 paginaDeFaleComNosco.submitReclamaçao();
		 //captur alerta
		 paginaDeFaleComNosco.capiturandoAlerta();
		 //checar mensagem de mensagem enviada
		 paginaDeFaleComNosco.checarMenssagemDeSucessoCarrinho();
		 
	 }
}
