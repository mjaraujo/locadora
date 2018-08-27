package br.com.mjasistemas.constucaows.rest;
 
import java.util.Date;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
 
@Path("/")
public class HelloResource
{
	@GET
	@Produces("text/html; charset=UTF-8")//; charset=UTF-8
	public Response getStartingPage()
	{
		String output = "<h1>Hello World!<h1>" +
				"<p>O serviço RESTful está funcionando <br>Data " + new Date().toString() + "</p<br>";
		return Response.status(200).entity(output).build();
	}
}