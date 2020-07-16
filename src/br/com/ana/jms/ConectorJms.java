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
	
	public MessageProducer iniciaProducer(String nomeDestino,TipoSessao sessao) throws Exception {	
		Destination destino = iniciaConexaoParaUmDestino(nomeDestino,sessao);
		return session.createProducer(destino);
	}
	
	private Destination iniciaConexaoParaUmDestino(String nomeDestino,TipoSessao sessao) throws JMSException, NamingException {
		conexao.start();
		
		session = criaSessao(sessao);
		
		return (Destination) context.lookup(nomeDestino);
	}
	
	private Session criaSessao(TipoSessao tipoSessao) throws JMSException {
		
		return tipoSessao.criaSessao(conexao); 
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
	public void setClientId(String clientId) throws JMSException {
		conexao.setClientID(clientId);
		
	}


}
