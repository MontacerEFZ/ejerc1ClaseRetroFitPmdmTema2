package montacer.elfazazi.ejerc1claseretrofitpmdmtema2.conexiones;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitObject {
    public static final String BASE_URL="https://reqres.in/"; //la base de la url

    public Retrofit getConexion(){ //esto siempre es igual
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
