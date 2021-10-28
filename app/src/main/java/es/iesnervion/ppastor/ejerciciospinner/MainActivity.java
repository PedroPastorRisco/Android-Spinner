package es.iesnervion.ppastor.ejerciciospinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Ciudad sevilla=new Ciudad("Sevilla",R.drawable.sevilla);
    Ciudad roma=new Ciudad("Roma",R.drawable.roma);
    Ciudad malaga=new Ciudad("Malaga",R.drawable.malaga);
    Ciudad daniel=new Ciudad("Daniel",R.drawable.huevo);

    Ciudad[] ciudades ={sevilla,roma,malaga,daniel};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner lista = findViewById(R.id.spinner);
        TextView texto = findViewById(R.id.textView);
        IconicAdapter par = new IconicAdapter<Object>(this, datos);
        lista.setAdapter(par);
        lista.setClickable(true);
    }
    class IconicAdapter<T> extends BaseAdapter {
        Context context;
        T[] listaDatos;

        public IconicAdapter(Context context, T[] objects) {
            this.context=context;
            this.listaDatos=objects;
        }
        @Override
        public int getItemViewType(int position) {
            int layout;
            Object objecto=getItem(position);

            if(objecto instanceof Ciudad) {
                layout=0;
            }else {
                if(objecto instanceof Equipo){
                    layout = 1;
                }else{
                    layout = 2;
                }
            }
            return layout;
        }
        @Override
        public int getViewTypeCount() {
            return 3;
        }

        @Override
        public int getCount() {
            return listaDatos.length;
        }

        @Override
        public Object getItem(int i) {
            return listaDatos[i];
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }
}