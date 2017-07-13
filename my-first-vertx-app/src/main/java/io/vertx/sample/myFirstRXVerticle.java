package io.vertx.sample;

import io.vertx.rxjava.core.AbstractVerticle;
import io.vertx.rxjava.core.http.HttpServer;

public class myFirstRXVerticle extends AbstractVerticle {

    @Override
    public void start() {

        HttpServer server = vertx.createHttpServer();
        server.requestStream().toObservable()
            .subscribe(req -> req.response().end("Hello from " + 
            Thread.currentThread().getName()));
        server.rxListen(8080).subscribe();
    }
}
