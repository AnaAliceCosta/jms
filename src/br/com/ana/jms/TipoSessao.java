package br.com.ana.jms;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

public interface TipoSessao {
	Session criaSessao(Connection conexao)  throws JMSException;
}
