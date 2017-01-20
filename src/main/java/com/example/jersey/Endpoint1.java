package com.example.jersey;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by icttb0 on 20/01/2017.
 */
@Component
@Path("/ep1")
public class Endpoint1 {
    public Endpoint1() {
    }

    @GET
    public String message() {
        return "Hello from ep1";
    }
}
