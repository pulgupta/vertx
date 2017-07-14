package io.vertx.book.http;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;

public class HelloMicroservice extends AbstractVerticle {

    @Override
    public void start() {

        Router router = Router.router(vertx);
        router.get("/").handler(rc -> rc.response().end("Hello Microservices"));
        router.get("/:name").handler(rc -> rc.response().end("Hello " + rc.pathParam("name")));

        vertx.createHttpServer()
            .requestHandler(//This is just a lambda which we are passing as a function
                //req -> req.response().end("Hello Server"))
                router::accept)
            .listen(8080);
    }
}
