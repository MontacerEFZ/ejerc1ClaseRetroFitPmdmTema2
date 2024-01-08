package montacer.elfazazi.ejerc1claseretrofitpmdmtema2.conexiones;

import montacer.elfazazi.ejerc1claseretrofitpmdmtema2.modelos.Respuesta;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiConexiones {
    @GET("/api/users?") //este es el endpoint q despues le añadiremos la info necesaria para ir a la pagina 1 o 2 pero esta parte de la url se repite
    Call<Respuesta> getUsers(@Query("page") int pagina);//respuesta viene despues de ver el json y ver que tipo de informacion tiene y es la q nos interesa,
                                        //"page" tiene que coincidir con el elemento del json
}
