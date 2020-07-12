package br.com.ana.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MessageListner implements MessageListener {

	@Override
	public void onMessage(Message mensagem) {
		TextMessage texto = (TextMessage) mensagem;
		try {
			System.out.println(texto.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
