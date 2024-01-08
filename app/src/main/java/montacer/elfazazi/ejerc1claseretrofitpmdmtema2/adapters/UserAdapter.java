package montacer.elfazazi.ejerc1claseretrofitpmdmtema2.adapters;

import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import montacer.elfazazi.ejerc1claseretrofitpmdmtema2.R;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserVH> {
    @NonNull
    @Override
    public UserVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull UserVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class UserVH extends RecyclerView.ViewHolder {

        ImageView imgUser;
        TextView lbNombre,lbApellidos, lbEmail;
        public UserVH(@NonNull View itemView) {
            super(itemView);
            imgUser = itemView.findViewById(R.id.imgImagenUsercard);
            lbNombre = itemView.findViewById(R.id.lbNombreUserCard);
            lbApellidos = itemView.findViewById(R.id.lbApellidosUserCard);
            lbEmail = itemView.findViewById(R.id.lbEmailUserCard);
        }
    }
}
