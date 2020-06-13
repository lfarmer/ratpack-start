package org.example.ratpack;

import org.example.ratpack.handlers.CorsHandler;
import ratpack.server.RatpackServer;

public class Application {

    public static void main(String[] args) throws Exception {
        RatpackServer.start(server ->
                server.handlers(chain -> chain
                        .all(new CorsHandler())
                        .get(ctx -> ctx.render("Ratpack is a GO!!!"))));
    }

}
