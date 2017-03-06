package com.learning.poc.rest.impl;

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

import com.learning.poc.dto.Employee;

@Path("/employee")
public class RestImpl {
	
	 public static HashMap<Integer, Employee> empMap = new HashMap<>();
	 public static HashMap<Integer, String> employee = new HashMap<Integer, String>();
	 
	 public final String EMP_VAIBHAV = "Vaibhav";
	 public final String EMP_APURVA = "Apurva";
	 
	 static{
		 empMap.put(1, new Employee(1, "Vaibhav", "P", "9890098900", "Pune"));
		 empMap.put(2, new Employee(2, "Apurva", "P", "9890098900", "Pune"));
	 }
	
	 @GET
	 @Path("/getDetails")
	 public Object getEmpDetails(@QueryParam("name")String name) {
		 Employee emp = null;
		 if(EMP_APURVA.equalsIgnoreCase(name)) {
			 emp = empMap.get(2);
		 } else if(EMP_VAIBHAV.equalsIgnoreCase(name)) {
			 emp = empMap.get(1);
		 }
		 return Response.status(Status.OK).entity(emp).build();
	 }
	 
	 @GET
	 @Path("/emp")
	 public Response getEmpList(){
		 return Response.status(Status.OK).entity(empMap.values()).build();
	 }
	 
	 @POST
	 @Consumes("application/x-www-form-urlencoded")
	 @Path("/emp")
	 public Response insertEmp(@FormParam("id") int id,@FormParam("name") String name){
		 employee.put(id, name);
		 return Response.status(Status.OK).entity(employee).build();
	 }
	 
	 @DELETE
	 @Path("/emp/{id}")
	 public Response delteEmp(@PathParam("id") int id){
		 employee.remove(id);
		 return Response.status(Status.OK).entity(employee).build();
	 }
	 
	 @PUT
	 @Consumes("application/x-www-form-urlencoded")
	 @Path("/emp/{id}")
	 public Response updateEmp(@PathParam("id") int id,@FormParam("name") String name){
		 employee.put(id, name);
		 return Response.status(Status.OK).entity(employee).build();
	 }
}
