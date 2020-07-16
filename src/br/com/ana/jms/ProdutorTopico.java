package br.com.ana.jms;

import javax.jms.Message;
import javax.jms.MessageProducer;


public class ProdutorTopico {

	public static void main(String[] args) throws Exception {
		
		ConectorJms conector = new ConectorJms();
		MessageProducer topico = conector.iniciaProducer("loja", new SessaoTopico());

		Message mensagem = conector.criaMensagemDeTexto("<mensagem>oi</mensagem>");
		topico.send(mensagem);
		
		conector.encerraConeccao();
		
	}
}
