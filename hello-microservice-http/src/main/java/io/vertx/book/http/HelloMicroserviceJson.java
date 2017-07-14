package io.vertx.book.http;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class HelloMicroserviceJson extends AbstractVerticle {

    @Override
    public void start() {

        Router router = Router.router(vertx);
        router.get("/").handler(this::hello);
        router.get("/:name").handler(this::hello);

        vertx.createHttpServer()
            .requestHandler(router::accept)
            .listen(8080);
    }

    private void hello(RoutingContext rc) {
        String message = "Hello";
        if(rc.pathParam("name") != null) {
            message+= " " + rc.pathParam("name");
        }
    }
}