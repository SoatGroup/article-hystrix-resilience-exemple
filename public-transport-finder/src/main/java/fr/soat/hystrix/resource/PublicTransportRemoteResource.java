package fr.soat.hystrix.resource;

import fr.soat.hystrix.model.RemoteItinerary;
import fr.soat.hystrix.model.RemoteItineraryResponse;
import fr.soat.hystrix.service.PublicTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("itineraries/publicTransportRemote")
public class PublicTransportRemoteResource {

    @Autowired
    private PublicTransportService publicTransportService;

    @GET
    @Path("find")
    @Produces(MediaType.APPLICATION_JSON)
    public RemoteItineraryResponse getItineraries(@QueryParam("from") String from, @QueryParam("to") String to) {
        List<RemoteItinerary> itineraries = publicTransportService.getItineraries(from, to);
        RemoteItineraryResponse itineraryResponse = new RemoteItineraryResponse(itineraries);
        return itineraryResponse;
    }
}
