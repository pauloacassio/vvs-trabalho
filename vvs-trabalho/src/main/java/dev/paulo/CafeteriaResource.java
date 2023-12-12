package dev.paulo;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/cafeteria")
@Transactional
/*
 * Classe para configuração de end points de cafeterias
 */
public class CafeteriaResource {

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    // End point para salvar Cafeteria
    public Cafeteria save(@FormParam("nome") String nome, @FormParam("endereco") String endereco) {
        Cafeteria c = new Cafeteria();
        c.setNome(nome);
        c.setEndereco(endereco);
        // 2 - O método do Panache `persist` possibilita persistir um objeto.
        c.persist();
        return c;
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    // End point para listar Cafeterias
    public List<Cafeteria> list() {
        return Cafeteria.listAll();
    }

    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    // End point para listar Cafeteria por ID
    public Cafeteria list(@PathParam("id") Long id) {
        return Cafeteria.findById(id);
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    // End point para deletar Cafeteria
    public Cafeteria delete(@PathParam("id") Long id) {
        Cafeteria c = Cafeteria.findById(id);
        c.delete();
        return c;
    }

    @PUT
    @Path("/edit")
    @Produces(MediaType.APPLICATION_JSON)
    // End point para editar Cafeteria
    public Cafeteria edit(@FormParam("id") Long id, @FormParam("nome") String nome, @FormParam("endereco") String endereco) {
        Cafeteria c = Cafeteria.findById(id);
        c.setNome(nome);
        c.setEndereco(endereco);
        return c;
    }

}