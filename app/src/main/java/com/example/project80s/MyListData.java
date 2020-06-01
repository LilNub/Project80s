package com.example.project80s;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project80s.R;
import com.firebase.client.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyListData extends AppCompatActivity {
    Activity activity;
    ListView listView;
    ListAdapter adapter;
    private FirebaseAuth auth;
    ProgressBar progressBar;
    private ArrayList<HashMap<String, String>> list = new ArrayList<>();
    DatabaseReference mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_data);
        activity = this;
        auth = FirebaseAuth.getInstance();
        listView = findViewById(R.id.ListView);
        try {
            mRef = FirebaseDatabase.getInstance().getReference()
                    .child("Admin").child(auth.getUid()).child("Order_Shop");
            progressBar = findViewById(R.id.progressBar2);
            progressBar.setVisibility(View.VISIBLE);
            getDataValue();
        }catch (NullPointerException e){
            Intent a = new Intent(MyListData.this, Login.class);
            startActivity(a);
            Toast.makeText(MyListData.this, "Login First", Toast.LENGTH_LONG).show();
        }

    }

    private void getDataValue() {
        list = new ArrayList<>();
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String id = snapshot.getKey();
                    String paket = (String) snapshot.child("paket").getValue();
                    String jenis = (String) snapshot.child("jenis").getValue();
                    String harga = (String) snapshot.child("harga").getValue();

                    HashMap<String, String> data = new HashMap<>();
                    data.put("key", id);
                    data.put("paket", paket);
                    data.put("jenis", jenis);
                    data.put("harga", harga);
                    list.add(data);
                }
                adapter = new ListAdapter(activity, list, R.layout.list_item, new String[]{"paket","jenis","harga"},
                        new int[]{ R.id.paket, R.id.jenis, R.id.harga});
                Parcelable state = listView.onSaveInstanceState();
                listView.setAdapter(adapter);
                listView.onRestoreInstanceState(state);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public class ListAdapter extends SimpleAdapter{
        private Context mContext;
        public LayoutInflater inflater = null;

        public ListAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to){
            super(context, data, resource, from, to);
            mContext = context;
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            View vi = convertView;
            if(convertView == null)

                vi = inflater.inflate(R.layout.list_item, null);
            HashMap<String, Object> data = (HashMap<String, Object>) getItem(position);
            final ImageButton btnDelete = vi.findViewById(R.id.delete);
            final TextView paket = vi.findViewById(R.id.paket);
            final TextView jenis = vi.findViewById(R.id.jenis);
            final TextView harga = vi.findViewById(R.id.harga);

            final String strKey = (String) data.get("key");
            final String strPaket = (String) data.get("paket");
            final String strJenis = (String) data.get("jenis");
            final String strHarga = (String) data.get("harga");

            paket.setText(strPaket);
            jenis.setText(strJenis);
            harga.setText(strHarga);
            progressBar.setVisibility(View.GONE);
            btnDelete.setOnClickListener(view -> Delete(strKey));
        return vi;
        }
    }

    public void Delete(String keyID){
        Query applesQuery = mRef.child(keyID);

        applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dummySnapshot: dataSnapshot.getChildren()) {
                    dummySnapshot.getRef().removeValue();
                }
                getDataValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("delete", "onCancelled", databaseError.toException());
            }
        });
    }


}
