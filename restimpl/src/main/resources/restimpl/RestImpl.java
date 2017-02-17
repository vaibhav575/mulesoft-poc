package restimpl;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/rest")
public class RestImpl {
	
	 public static HashMap<Integer, String> empList = new HashMap<Integer, String>();
	 
	 static{
		 empList.put(1, "Vaibhav");
		 empList.put(2, "Varun");
	 }
	
	 @GET
	 @Path("/hello")
	 public Response sayHello(@QueryParam("name")String name) {
		 return Response.status(Status.OK).entity("hello " + name).build();
	 }
	 
	 @GET
	 @Path("/emp")
	 public Response getEmpList(){
		 return Response.status(Status.OK).entity(empList).build();
	 }
	 
	 @POST
	 @Consumes("application/x-www-form-urlencoded")
	 @Path("/emp")
	 public Response insertEmp(@FormParam("id") int id,@FormParam("name") String name){
		 empList.put(id, name);
		 return Response.status(Status.OK).entity(empList).build();
	 }
	 
	 @DELETE
	 @Path("/emp/{id}")
	 public Response delteEmp(@PathParam("id") int id){
		 empList.remove(id);
		 return Response.status(Status.OK).entity(empList).build();
	 }
	 
	 @PUT
	 @Consumes("application/x-www-form-urlencoded")
	 @Path("/emp/{id}")
	 public Response updateEmp(@PathParam("id") int id,@FormParam("name") String name){
		 empList.put(id, name);
		 return Response.status(Status.OK).entity(empList).build();
	 }
	 
}
