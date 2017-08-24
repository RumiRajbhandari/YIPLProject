package com.example.root.yiplproject.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.example.root.yiplproject.FirstProject;
import com.example.root.yiplproject.ListofContractor;
import com.example.root.yiplproject.R;
import com.example.root.yiplproject.SecondProject;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListOfProjectsFragment extends Fragment {

    View mView;
    Button signup,login,forum;
    EditText email,password;
    public String mail,pass;
//    Comment comment;
    public String userid;
    String TAG="TAG";

    public ListOfProjectsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.activity_listof_contractor, container, false);
        return mView;

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      ListView  listView = (ListView) view.findViewById(R.id.list1);
        ArrayAdapter<String> madapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.projects));

        // return view;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent aboutcsit = new Intent(getActivity(), FirstProject.class);
                    // aboutcsit.putExtra("listname",listView.getItemAtPosition(i).toString());
                    startActivity(aboutcsit);
                }
                else if (i == 1) {
                    Intent pakistan = new Intent(getActivity(), SecondProject.class);
                    //pakistan.putExtra("listname",listView.getItemAtPosition(i).toString());
                    startActivity(pakistan);
                }
            }
        });
        listView.setAdapter(madapter);
    }

    }


