package com.example.basictestdemo.framework.mvp.app.dashboard.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basictestdemo.R;
import com.example.basictestdemo.framework.mvp.app.dashboard.adapter.DataAdapter;
import com.example.basictestdemo.framework.mvp.app.dashboard.model.DataItem;

import java.util.List;

public class HomeFragment extends Fragment implements HomeContract.View {

    private HomePresenter presenter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = root.findViewById(R.id.recycler_view_home);
        progressBar = root.findViewById(R.id.progress_bar_home);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        presenter = new HomePresenter(this);
        presenter.fetchData();

        return root;
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void displayData(List<DataItem> items) {
        DataAdapter adapter = new DataAdapter(items);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        presenter.detachView();
        super.onDestroyView();
    }
}

