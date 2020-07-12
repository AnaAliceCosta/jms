package br.com.ana.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConectorJms {

	private InitialContext context;
	private ConnectionFactory cf;
	private Connection conexao;
	private Session session;

	
	public ConectorJms() throws Exception{
		context = new InitialContext();
		cf = (ConnectionFactory)context.lookup("ConnectionFactory");
		conexao = cf.createConnection();
	}
	public MessageProducer iniciaProducer(String nomeDestino) throws Exception {	
		Destination destino = iniciaConexaoParaUmDestino(nomeDestino);
		return session.createProducer(destino);
	}
	
	private Destination iniciaConexaoParaUmDestino(String nomeDestino) throws JMSException, NamingException {
		conexao.start();
		
		session = conexao.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destino = (Destination) context.lookup(nomeDestino);
		return destino;
	}	
	
	public void encerraConeccao() throws Exception{
		session.close();
		conexao.close();    
		context.close();
		
	}

	public Message criaMensagemDeTexto(String mensagem) throws Exception {
		return session.createTextMessage(mensagem);
	}
	public MessageConsumer iniciaConsumer(String nomeDestino) throws JMSException, NamingException {
		Destination destino = iniciaConexaoParaUmDestino(nomeDestino);
		return session.createConsumer(destino);
	}

}
