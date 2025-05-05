## A sample repository about rate limiting


The `App#main` method is creating an instance of `Server` and print the rate of accepted requests every seconds.

```java
final Server server = new Server();
EXECUTOR.scheduleAtFixedRate(() -> System.out.printf("Current rate is %.2f\n", server.getRate()), 1, 1, TimeUnit.SECONDS);
```


It also starts simulating a client sending 100 requests per second.

```java
EXECUTOR.scheduleAtFixedRate(server::consume, 0, 10, TimeUnit.MILLISECONDS);
```

**Your goal:** Implement the [`com.tricentis.neoload.Server.allow`](https://github.com/lcharlois-neotys/rate-limit-sample/blob/332c244938c0b66bd50af3893f3361504cd7c848/src/main/java/com/tricentis/neoload/Server.java#L28) method to limit the rate of accepted requests to 2 per second.
