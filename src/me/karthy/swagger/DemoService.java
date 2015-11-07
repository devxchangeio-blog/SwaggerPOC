package me.karthy.swagger;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Path("/demo")
@Api(value = "demo", description = "SwaggerUI - Demo Service")
public class DemoService {

	@GET
	@Path("/getSomething/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Demo Service - GetSomething GET Method")
	public Response getSomething(
			@ApiParam(value = "param", required = true) @PathParam("param") String msg) {

		Map<String, String> entity = new HashMap<>();
		entity.put("msg", msg);

		Gson gson = new Gson();
		String json = gson.toJson(entity);

		return Response.status(Response.Status.OK).entity(json)
				.type(MediaType.APPLICATION_JSON).build();

	}
}
