package com.example.jersey;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by icttb0 on 20/01/2017.
 */
@Component
@Path("/ep2")
public class Endpoint2 {

    public Endpoint2() {
    }

    @GET
    public String message() {
        return "Hello from ep2";
    }
}
