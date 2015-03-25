package org.nraov.vertx.jersey.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test2")
@Produces(MediaType.APPLICATION_JSON)
public class Test2Resource {

	@GET
	@Path("id")
	public String getId() {
        return "Id from Test2Resource";
	}
}
