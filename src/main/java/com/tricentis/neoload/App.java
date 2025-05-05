package com.tricentis.neoload;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
public class App {

	private static final ScheduledExecutorService EXECUTOR = Executors.newScheduledThreadPool(10);

	public static void main(String[] args) {
		final Server server = new Server();
		EXECUTOR.scheduleAtFixedRate(() -> System.out.printf("Current rate is %.2f\n", server.getRate()), 1, 1, TimeUnit.SECONDS);
		EXECUTOR.scheduleAtFixedRate(server::consume, 0, 10, TimeUnit.MILLISECONDS);
	}
}
