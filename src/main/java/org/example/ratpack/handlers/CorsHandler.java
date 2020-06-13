package org.example.ratpack.handlers;

import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.http.MutableHeaders;

public class CorsHandler implements Handler {

    @Override
    public void handle(Context ctx) {
        MutableHeaders headers = ctx.getResponse().getHeaders();
        headers.set("Access-Control-Allow-Origin", "http://localhost");
        headers.set("Access-Control-Allow-Headers", "x-requested-with, origin, content-type, accept");
        ctx.next();
    }

}
