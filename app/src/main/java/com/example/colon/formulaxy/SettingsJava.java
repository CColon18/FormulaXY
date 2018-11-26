package com.example.colon.formulaxy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class SettingsJava  extends Fragment {
    EditText group_id;
    Button grp_id;
    Button create_group;
    EditText create_group_name;
    EditText create_group_code;
    Button create_user;
    Button login;
    EditText User;
    EditText Password;

    public SettingsJava() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.list_settings, container, false);
        group_id = view.findViewById(R.id.txtnomGroup);
        grp_id = view.findViewById(R.id.grp_get);

        create_group_name = view.findViewById(R.id.GRP_NAME);
        create_group_code = view.findViewById(R.id.GRP_CODE);

        User = view.findViewById(R.id.Username);
        Password = view.findViewById(R.id.Passd);

        create_user = view.findViewById(R.id.Crear_Usuario);
        login = view.findViewById(R.id.Login);

        grp_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.Group = group_id.getText().toString();
                Toast post_error = Toast.makeText(getActivity(), "Se ah cambiado el grupo", Toast.LENGTH_SHORT);
                post_error.show();
            }
        });

        create_group = view.findViewById(R.id.create_grp);
        create_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = create_group_name.getText().toString();
                String code = create_group_code.getText().toString();

                if(MainActivity.token == ""){
                    Toast post_error = Toast.makeText(getActivity(), "No se ah iniciado sesion", Toast.LENGTH_SHORT);
                    post_error.show();
                }
                else{
                    FxyApi api = new FxyApi();
                    if(api.createGroup(name, code) != "Ok"){
                        Toast post_error = Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT);
                        post_error.show();
                    }
                    else{
                        Toast post_error = Toast.makeText(getActivity(), "Grupo creado!", Toast.LENGTH_SHORT);
                        post_error.show();
                    }
                }
            }
        });

        create_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = User.getText().toString();
                String password = Password.getText().toString();

                Log.d("User Pass",name + " " + password);

                FxyApi api = new FxyApi();
                if(api.createUser(name, password) != "Ok"){
                    Toast post_error = Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT);
                    post_error.show();
                }
                else{
                    Toast post_error = Toast.makeText(getActivity(), "User created", Toast.LENGTH_SHORT);
                    post_error.show();
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = User.getText().toString();
                String password = Password.getText().toString();

                Log.d("User Pass",name + " " + password);

                FxyApi api = new FxyApi();
                if(api.login(name, password) != "Ok"){
                    Toast post_error = Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT);
                    post_error.show();
                }
                else{
                    Toast post_error = Toast.makeText(getActivity(), "Sesion iniciada", Toast.LENGTH_SHORT);
                    post_error.show();
                }
            }
        });

        return view;
    }
}