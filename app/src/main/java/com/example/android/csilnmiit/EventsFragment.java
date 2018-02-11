package com.example.android.csilnmiit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.android.csilnmiit.Adapter.CouncilAdapter;
import com.example.android.csilnmiit.Model.Member;

import java.io.IOException;
import java.util.ArrayList;

public class EventsFragment extends Fragment implements CouncilAdapter.ListItemClickListener{
    RecyclerView recyclerView;
    CouncilAdapter adapter;
    ArrayList<Member> members;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_events, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view1);
        prepareMembers();

        this.adapter = new CouncilAdapter(this.getActivity(), members, this);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(this.adapter);
        return v;

    }

    @Override
    public void onListItemClick(int clickedItemIndex) throws IOException {

    }
    public void  prepareMembers(){
        members=new ArrayList<Member>();
        Member m=new Member("Nimish","Event Organiser",null);
        members.add(m); members.add(m); members.add(m); members.add(m); members.add(m); members.add(m); members.add(m);
        members.add(m); members.add(m); members.add(m); members.add(m);


    }
}
