package com.tricentis.neoload;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lcharlois
 * @since 30/04/2025.
 */
public class Server {

	private final AtomicInteger count = new AtomicInteger(0);
	private final long startTime;

	public Server() {
		this.startTime = System.currentTimeMillis();
	}

	public void consume() {
		if (allow()) {
			count.incrementAndGet();
		}
	}

	public float getRate() {
		return count.get() * 1.0f / (System.currentTimeMillis() - startTime) * 1000;
	}

	private boolean allow() {
		//TODO rate limit
		return true;
	}

}
