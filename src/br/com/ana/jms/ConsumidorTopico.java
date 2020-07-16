package br.com.ana.jms;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.naming.InitialContext;

public class ConsumidorTopico {

	public static void main(String[] args) throws Exception {
		
		ConectorJms conector = new ConectorJms();
		conector.setClientId("estoque");
		MessageConsumer consumer = conector.iniciaConsumer("financeiro");

		consumer.setMessageListener(new MessageListner());

		new Scanner(System.in).nextLine();
		
		conector.encerraConeccao();
	}
}
