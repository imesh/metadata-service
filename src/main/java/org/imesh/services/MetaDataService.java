package org.imesh.services;

import org.imesh.data.Database;
import org.imesh.domain.Property;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by imesh on 6/9/14.
 */
@Path("/metadata")
public class MetaDataService {
    @GET
    @Path("/echo/{in}")
    public Response echo(@PathParam("in") String in) {
        return Response.status(200).entity("Hello: " + in).build();
    }

    @POST
    @Path("/{environment-id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(@PathParam("environment-id") String environmentId, Property property) {
        Map<String, Property> properties = Database.getInstance().getMetaData().get(environmentId);
        if(properties == null) {
            properties = new HashMap<String, Property>();
        }
        properties.put(property.getName(), property);
        Database.getInstance().getMetaData().put(environmentId, properties);
        return Response.status(200).build();
    }

    @GET
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        return Response.status(200).entity(Database.getInstance().getMetaData()).build();
    }

    @GET
    @Path("/{environment-id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("environment-id") String environmentId) {
        return Response.status(200).entity(Database.getInstance().getMetaData().get(environmentId)).build();
    }

    @GET
    @Path("/{environment-id}/{property-name}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("environment-id") String environmentId, @PathParam("property-name") String propertyName) {
        if(Database.getInstance().getMetaData().containsKey(environmentId)) {
            Map<String, Property> properties = Database.getInstance().getMetaData().get(environmentId);
            if(properties != null) {
                Property property = properties.get(propertyName);
                return Response.status(200).entity(property).build();
            }
        }
        return Response.status(404).build();
    }

    @DELETE
    @Path("/{environment-id}")
    public Response delete(@PathParam("environment-id") String environmentId, @PathParam("property-name") String propertyName) {
        if(Database.getInstance().getMetaData().containsKey(environmentId)) {
            Map<String, Property> properties = Database.getInstance().getMetaData().get(environmentId);
            if((properties == null) && (properties.containsKey(propertyName))) {
                properties.remove(propertyName);
                return Response.status(200).build();
            }
        }
        return Response.status(404).build();
    }
}
