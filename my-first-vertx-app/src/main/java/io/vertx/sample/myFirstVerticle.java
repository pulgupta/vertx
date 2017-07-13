package io.vertx.sample;

import io.vertx.core.AbstractVerticle;

public class myFirstVerticle extends AbstractVerticle {

    @Override
    public void start() {	
	vertx.createHttpServer()
		.requestHandler(req -> {
			req.response().end("hello from " + Thread.currentThread().getName());
		})
		.listen(8080);
    }
}
