package com.example.colon.formulaxy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

public class FisicaJava2 extends Fragment {

    ListView listFis;
    ArrayAdapter<String> listViewAdapterFis;

    public FisicaJava2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fisica2, container, false);
        FxyApi api = new FxyApi();
        //api.login("jose", "jose");

        JSONArray posts = api.getPostByTopic(MainActivity.Group, "Fisica");
        try {
            Log.d("Results:", posts.getJSONObject(0).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        int menu_lenght = 1;
        if(posts.length() > 0){
            menu_lenght = posts.length();
        }
        else{
            if(MainActivity.token == ""){
                Toast post_error = Toast.makeText(getActivity(), "No se ha iniciado sesion", Toast.LENGTH_SHORT);
                post_error.show();
            }
            else if (MainActivity.Group == ""){
                Toast post_error = Toast.makeText(getActivity(), "No se ha encontrado grupo: "+MainActivity.Group, Toast.LENGTH_SHORT);
                post_error.show();
            }
            Toast post_error = Toast.makeText(getActivity(), "No se han encontrado posts", Toast.LENGTH_SHORT);
            post_error.show();
        }
        String[] menuItems = new String[menu_lenght];

        for (int i =0; i < posts.length(); i++){
            Post pst = new Post();
            try {
                pst = pst.JsonToPost(posts.getJSONObject(i));
                menuItems[i] = "[" +pst.title+ "]" + "\n\n" + pst.content;
                Log.d("title", pst.title);
            } catch (JSONException e) {
                Toast post_error = Toast.makeText(getActivity(), "Error cargando posts", Toast.LENGTH_SHORT);
                post_error.show();
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        for(int i =0; i < menuItems.length; i++){
            if(menuItems[i] == null)menuItems[i] = " ";
        }

        listFis = view.findViewById(R.id.mainMenuFis);
        listViewAdapterFis = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );
        listFis.setAdapter(listViewAdapterFis);

        return view;
    }
}