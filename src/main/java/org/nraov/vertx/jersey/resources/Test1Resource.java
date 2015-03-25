package org.nraov.vertx.jersey.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test1")
@Produces(MediaType.APPLICATION_JSON)
public class Test1Resource {

	@GET
	@Path("id")
	public String getId() {
		return "Id from Test1Resource";
	}
}
