package br.com.ana.jms;

import javax.jms.Message;
import javax.jms.MessageProducer;

public class ProdutorFila {

	public static void main(String[] args) throws Exception {
		
		
		ConectorJms conector = new ConectorJms();
		MessageProducer fila = conector.iniciaProducer("financeiro", new SessaoFila());

		Message mensagem = conector.criaMensagemDeTexto("<mensagem>oi</mensagem>");
		fila.send(mensagem);
		
		conector.encerraConeccao();
		
	}
}
