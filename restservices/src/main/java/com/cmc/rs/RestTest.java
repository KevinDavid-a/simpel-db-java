package com.cmc.rs;

import com.cmc.entities.Test;
import com.cmc.services.TestService;

import javax.ws.rs.*;
import java.util.ArrayList;

@Path("/consumo")
public class RestTest {

    @Path("/insertar")
    @POST
    @Consumes("application/json")
    public String insert(Test test) {
        TestService.insert(test);
      return "It has been inserted";
    }

    @Path("/consultar")
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    public ArrayList<Test> consultar() {
        return TestService.findAll();
    }

    @Path("/test")
    @GET
    public String test(){
        return "Test";
    }

}
