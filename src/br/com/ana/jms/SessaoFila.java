package br.com.ana.jms;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

public class SessaoFila implements TipoSessao{

	@Override
	public Session criaSessao(Connection conexao) throws JMSException {
		
		return conexao.createSession(false, Session.AUTO_ACKNOWLEDGE);
	}



}
