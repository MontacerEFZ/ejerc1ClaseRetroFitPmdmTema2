package montacer.elfazazi.ejerc1claseretrofitpmdmtema2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import montacer.elfazazi.ejerc1claseretrofitpmdmtema2.adapters.UserAdapter;
import montacer.elfazazi.ejerc1claseretrofitpmdmtema2.conexiones.ApiConexiones;
import montacer.elfazazi.ejerc1claseretrofitpmdmtema2.conexiones.RetrofitObject;
import montacer.elfazazi.ejerc1claseretrofitpmdmtema2.databinding.ActivityMainBinding;
import montacer.elfazazi.ejerc1claseretrofitpmdmtema2.modelos.DataItem;
import montacer.elfazazi.ejerc1claseretrofitpmdmtema2.modelos.Respuesta;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    UserAdapter adapter;
    private RecyclerView.LayoutManager lm;
    private ArrayList<DataItem> listaUsuarios; //dataitem porq es lo q devuelve el json, dentro de respuesta hay un dataitem
    private Retrofit retrofit;
    private ApiConexiones api;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listaUsuarios = new ArrayList<>();
        adapter = new UserAdapter(listaUsuarios, R.layout.user_view_holder, this);
        lm = new LinearLayoutManager(this);

        binding.contenedorMain.setAdapter(adapter);
        binding.contenedorMain.setLayoutManager(lm);

        retrofit = RetrofitObject.getConexion();
        api = retrofit.create(ApiConexiones.class);

        cargarIsuarios("1"); //este solo es de prueba, no cargara la 2 pagina
    }

    private void cargarIsuarios(String s) {
        Call<Respuesta> dogetUsers = api.getUsers(Integer.parseInt(s));

        dogetUsers.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                if (response.code() == HttpsURLConnection.HTTP_OK
                 && response.body() != null){
                    listaUsuarios.addAll(response.body().getData());
                    adapter.notifyItemRangeInserted(0, listaUsuarios.size());
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error al cargar datos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}