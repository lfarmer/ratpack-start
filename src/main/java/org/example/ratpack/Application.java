package org.example.ratpack;

import ratpack.server.RatpackServer;

public class Application {

    public static void main(String[] args) throws Exception {
        RatpackServer.start(server ->
                server.handlers(chain ->
                        chain.get(ctx ->
                                ctx.render("Ratpack is a GO!!!"))));
    }

}
