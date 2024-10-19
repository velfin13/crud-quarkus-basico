package me.velfinvelasquez;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.velfinvelasquez.entities.Product;
import me.velfinvelasquez.repository.ProductRepository;

@Path("/product")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductApi {

    @Inject
    ProductRepository pr;

    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> hello() {
        return pr.listProduct();
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Product p) {
        pr.createProducto(p);
        return Response.ok().build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") Long id) {
        pr.deleteById(id);
        return Response.ok().build();
    }
}
