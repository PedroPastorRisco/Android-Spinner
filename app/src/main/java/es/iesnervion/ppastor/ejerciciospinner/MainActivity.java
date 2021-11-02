package es.iesnervion.ppastor.ejerciciospinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
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
        IconicAdapter par = new IconicAdapter<Object>(this, ciudades);
        lista.setAdapter(par);
        lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                texto.setText(parent.getItemAtPosition(position).toString());
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {
                
            }
        });



        };

   class IconicAdapter<T> extends BaseAdapter implements SpinnerAdapter{
        Context context;
        T[] listaDatos;

        public IconicAdapter(Context context, T[] objects) {

            this.context=context;
            this.listaDatos=objects;
        }
        @Override
        public int getItemViewType(int position) {
            return 0;
        }
        @Override
        public int getViewTypeCount() {
            return 1;
        }

       @Override
       public boolean isEmpty() {
           return false;
       }

       @Override
       public void registerDataSetObserver(DataSetObserver dataSetObserver) {

       }

       @Override
       public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

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

       @Override
       public boolean hasStableIds() {
           return false;
       }

       @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View row = view;
            ViewHolder holder=null;
            ImageView image=null;
            TextView text=null;
            if(row==null){
                LayoutInflater inflater=getLayoutInflater();
                row = inflater.inflate(R.layout.layout_ciudad, viewGroup, false);
                text = (TextView) row.findViewById(R.id.label);
                image = (ImageView) row.findViewById(R.id.icon);
                holder = new ViewHolder (text,image);
                row.setTag(holder);
            }else{
                holder = (ViewHolder) row.getTag();
            }
            holder.getText().setText(getItem(i).toString());
            holder.getImage().setImageResource(((Ciudad) getItem(i)).getIdImagen());

            return row;
        }

       @Override
       public View getDropDownView(int i, View view, ViewGroup viewGroup) {
           View row = view;
           ViewHolderSimple holder=null;
           TextView text=null;
           if(row==null){
               LayoutInflater inflater=getLayoutInflater();
               row = inflater.inflate(R.layout.layout_general, viewGroup, false);
               text = (TextView) row.findViewById(R.id.label);
               holder = new ViewHolderSimple(text);
               row.setTag(holder);
           }else{
               holder = (ViewHolderSimple) row.getTag();
           }
           holder.getText().setText(getItem(i).toString());
           return row;
       }
   }


    class ViewHolder{
        TextView text;
        ImageView image;

        public ViewHolder(TextView text,ImageView image){
            this.text=text;
            this.image=image;
        }

        public TextView getText() {
            return text;
        }

        public void setTexto(TextView text) {
            this.text = text;
        }

        public ImageView getImage() {
            return image;
        }

        public void setImage(ImageView image) {
            this.image = image;
        }
    }
    class ViewHolderSimple{
        TextView text;
        public ViewHolderSimple(TextView text){
            this.text=text;

        }

        public TextView getText() {
            return text;
        }

        public void setTexto(TextView text) {
            this.text = text;
        }


    }
}