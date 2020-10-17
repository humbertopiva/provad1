package br.usjt.ads20.universidadeapp;

/**
 * Nome: Humberto Luiz Piva dos Santos
 * RA: 818234523
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.usjt.ads20.universidadeapp.model.Universidade;

public class UniversidadeAdapter extends BaseAdapter  {
    Universidade[] universidades;
    Context context;

    public UniversidadeAdapter(Context context, Universidade[] universidades){
        this.universidades = universidades;
        this.context = context;
    }

    @Override
    public int getCount() {
        return universidades.length;
    }

    @Override
    public Object getItem(int i) {
        if(i >= 0 && i < universidades.length){
            return universidades[i];
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_universidade, viewGroup, false);

            ImageView avatar = (ImageView) view.findViewById(R.id.avatar);
            TextView nomeUniversidade = (TextView) view.findViewById(R.id.nome_universidade);
            TextView pais = (TextView) view.findViewById(R.id.detalhe1_universidade);
            TextView url = (TextView) view.findViewById(R.id.detalhe2_universidade);

            view.setTag(new ViewHolder(avatar, nomeUniversidade, pais, url));
        }

        ViewHolder viewHolder = (ViewHolder)view.getTag();

        viewHolder.getNomeUniversidade().setText(universidades[i].getNome());
        viewHolder.getPais().setText(universidades[i].getPais());
        viewHolder.getUrl().setText(universidades[i].getWebPages());
        viewHolder.getImagemUniversidade().setImageBitmap(Util.criaAvatar(context, universidades[i].getSiglaPais()));

        return view;
    }

}
